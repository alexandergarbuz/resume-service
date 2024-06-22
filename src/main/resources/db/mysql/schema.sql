DROP SCHEMA IF EXISTS resume_manager_db;
CREATE SCHEMA resume_manager_db;
USE resume_manager_db;

-- ALTER DATABASE resume_manager_db 
-- DEFAULT CHARACTER SET utf8 
-- DEFAULT COLLATE utf8_general_ci;

-- CREATE USER 'resume_user'@'%' IDENTIFIED BY 'resume_password';
-- GRANT ALL PRIVILEGES ON resume_manager_db.* TO 'resume_user'@'%';

DROP TABLE IF EXISTS certification;
DROP TABLE IF EXISTS certification_seq;

DROP TABLE IF EXISTS contact_information;
DROP TABLE IF EXISTS contact_information_seq;

DROP TABLE IF EXISTS summary;
DROP TABLE IF EXISTS summary_seq;

DROP TABLE IF EXISTS education;
DROP TABLE IF EXISTS education_seq;

DROP TABLE IF EXISTS job_responsibility;
DROP TABLE IF EXISTS job_responsibility_seq;

DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS job_seq;

DROP TABLE IF EXISTS recommendation;
DROP TABLE IF EXISTS recommendation_seq;

DROP TABLE IF EXISTS reference;
DROP TABLE IF EXISTS reference_seq;

DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS skill_seq;

DROP TABLE IF EXISTS skill_group;
DROP TABLE IF EXISTS skill_group_seq;

DROP TABLE IF EXISTS resume;
DROP TABLE IF EXISTS resume_seq;


CREATE TABLE resume (
  id bigint NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE resume_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE certification (
  date date DEFAULT NULL,
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  authority varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Certification_Resume (resume_id),
  CONSTRAINT FK_Certification_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE certification_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE contact_information (
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  state varchar(2) DEFAULT NULL,
  zip varchar(5) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_Contact_information_Resume (resume_id),
  CONSTRAINT FK_Contact_information_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE contact_information_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE summary (
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  objective varchar(500) DEFAULT NULL,
  summary varchar(1000) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_Summary_Resume (resume_id),
  CONSTRAINT FK_Summary_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE summary_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE education (
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  degree varchar(255) DEFAULT NULL,
  end_date date DEFAULT NULL,
  start_date date DEFAULT NULL,
  comments varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Education_Resume (resume_id),
  CONSTRAINT FK_Education_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE education_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE job (
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  company_name varchar(255) DEFAULT NULL,
  location varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  end_date date DEFAULT NULL,
  start_date date DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Job_Resume (resume_id),
  CONSTRAINT FK_Job_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE job_responsibility (
  id bigint NOT NULL,
  job_id bigint DEFAULT NULL,
  text varchar(2000) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Job_responsibility_Job (job_id),
  CONSTRAINT FK_Job_responsibility_Job FOREIGN KEY (job_id) REFERENCES job (id)
) ENGINE=InnoDB;

CREATE TABLE job_responsibility_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE job_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE recommendation (
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  text varchar(1000) DEFAULT NULL,
  author varchar(255) DEFAULT NULL,
  author_title varchar(255) DEFAULT NULL,
  relationship varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Recommendation_Resume (resume_id),
  CONSTRAINT FK_Recommendation_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE recommendation_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE reference (
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Reference_Resume (resume_id),
  CONSTRAINT FK_Reference_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE reference_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE skill_group (
  id bigint NOT NULL,
  resume_id bigint DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_SKill_Group_Resume (resume_id),
  CONSTRAINT FK_SKill_Group_Resume FOREIGN KEY (resume_id) REFERENCES resume (id)
) ENGINE=InnoDB;

CREATE TABLE skill (
  id bigint NOT NULL,
  skill_group_id bigint DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_SKill_Skill_Group (skill_group_id),
  CONSTRAINT FK_SKill_Skill_Group FOREIGN KEY (skill_group_id) REFERENCES skill_group (id)
) ENGINE=InnoDB;

CREATE TABLE skill_group_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE skill_seq (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB;

INSERT INTO resume_seq VALUES (1);
INSERT INTO certification_seq VALUES (1);
INSERT INTO contact_information_seq VALUES (1);
INSERT INTO summary_seq VALUES (1);
INSERT INTO education_seq VALUES (1);
INSERT INTO job_responsibility_seq VALUES (1);
INSERT INTO job_seq VALUES (1);
INSERT INTO recommendation_seq VALUES (1);
INSERT INTO reference_seq VALUES (1);
INSERT INTO skill_group_seq VALUES (1);
INSERT INTO skill_seq VALUES (1);