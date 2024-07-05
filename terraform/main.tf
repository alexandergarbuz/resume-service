provider "aws" {
  region = "us-east-2"
}

data "aws_vpc" "default" {
  default = true
}

data "aws_subnets" "default" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.default.id]
  }
}

resource "aws_ecs_cluster" "dev_resume_service" {
  name = "dev-resume-service-tf"
}

resource "aws_lb" "resume_service_lb" {
  name               = "resume-service-lb"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.lb_sg.id]
  subnets            = data.aws_subnets.default.ids
}

resource "aws_security_group" "service_sg" {
  name        = "service-sg"
  description = "Allow all HTTP(s) traffic"
  vpc_id      = data.aws_vpc.default.id

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_security_group_rule" "allow_lb_to_mysql" {
  type              = "ingress"
  from_port         = 3306
  to_port           = 3306
  protocol          = "tcp"
  security_group_id = "sg-02a51fde21b44486c"  # MySQL security group ID
  source_security_group_id = aws_security_group.service_sg.id  
}


resource "aws_security_group" "lb_sg" {
  name        = "lb-sg"
  description = "Allow all HTTP(s) traffic"
  vpc_id      = data.aws_vpc.default.id

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_ecs_task_definition" "app" {
  family                   = "resume-service-task"
  container_definitions    = jsonencode([
    {
      name  = "resume-service"
      image = "alexandergarbuz/resume-service:main" # Replace with your image
      portMappings = [
        {
          containerPort = 80
          hostPort      = 80
        }
      ]
      environment = [
        {
          name  = "WEB_SERVER_CONTEXT_PATH"
          value = "/"
        },
        {
          name  = "WEB_SERVER_PORT"
          value = "80"
        },
        {
          name  = "MYSQL_PASSWORD"
          value = "resume_password"
        },
        {
          name  = "MYSQL_URL"
          value = "jdbc:mysql://database-1.cbcskeq2wn7n.us-east-2.rds.amazonaws.com:3306/resume_manager_db"
        },
        {
          name  = "MYSQL_USER"
          value = "resume_user"
        }
      ]
    }
  ])
  requires_compatibilities = ["FARGATE"]
  network_mode             = "awsvpc"
  memory                   = "512"
  cpu                      = "256"
//  execution_role_arn       = aws_iam_role.ecs_task_execution_role.arn
}

resource "aws_ecs_service" "app" {
  name            = "resume-service"
  cluster         = aws_ecs_cluster.dev_resume_service.id
  task_definition = aws_ecs_task_definition.app.arn
  desired_count   = 1
  launch_type     = "FARGATE"
  network_configuration {
    subnets         = data.aws_subnets.default.ids
    security_groups = [aws_security_group.service_sg.id]
    assign_public_ip = true
  }
  load_balancer {
    target_group_arn = aws_lb_target_group.app.arn
    container_name   = "resume-service"
    container_port   = 80
  }
  depends_on = [
    aws_lb_listener.frontend_http
  ]
}

resource "aws_lb_target_group" "app" {
  name        = "resume-service-tg"
  port        = 80
  protocol    = "HTTP"
  vpc_id      = data.aws_vpc.default.id
  target_type = "ip"
}
/*
resource "aws_lb_listener" "frontend_https" {
  load_balancer_arn = aws_lb.resume_service_lb.arn
  port              = 443
  protocol          = "HTTPS"
  ssl_policy        = "ELBSecurityPolicy-2016-08"
  certificate_arn   = aws_acm_certificate.cert.arn

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.app.arn
  }
}
*/
resource "aws_lb_listener" "frontend_http" {
  load_balancer_arn = aws_lb.resume_service_lb.arn
  port              = 80
  protocol          = "HTTP"

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.app.arn
  }
}



/*
resource "aws_acm_certificate" "cert" {
  domain_name       = "aws.garbuz.com"
  validation_method = "DNS"

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_route53_record" "cert_validation" {
  for_each = {
    for dvo in aws_acm_certificate.cert.domain_validation_options : dvo.domain_name => {
      name   = dvo.resource_record_name
      type   = dvo.resource_record_type
      record = dvo.resource_record_value
    }
  }

  zone_id = aws_route53_zone.main.zone_id
  name    = each.value.name
  type    = each.value.type
  ttl     = 60
  records = [each.value.record]
}

resource "aws_acm_certificate_validation" "cert_validation" {
  certificate_arn         = aws_acm_certificate.cert.arn
  validation_record_fqdns = [for record in aws_route53_record.cert_validation : record.fqdn]
}

resource "aws_route53_zone" "main" {
  name = "aws.garbuz.com"
}

resource "aws_route53_record" "www" {
  zone_id = aws_route53_zone.main.zone_id
  name    = "www.aws.garbuz.com"
  type    = "A"

  alias {
    name                   = aws_lb.resume_service_lb.dns_name
    zone_id                = aws_lb.resume_service_lb.zone_id
    evaluate_target_health = true
  }
}

resource "aws_route53_record" "root" {
  zone_id = aws_route53_zone.main.zone_id
  name    = "aws.garbuz.com"
  type    = "A"

  alias {
    name                   = aws_lb.resume_service_lb.dns_name
    zone_id                = aws_lb.resume_service_lb.zone_id
    evaluate_target_health = true
  }
}


*/
output "load_balancer_dns_name" {
  description = "The DNS name of the load balancer"
  value       = aws_lb.resume_service_lb.dns_name
}