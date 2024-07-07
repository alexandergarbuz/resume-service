CREATE DATABASE  IF NOT EXISTS `dev_resume_manager_db` 
/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ 
/*!80016 DEFAULT ENCRYPTION='N' */;
USE `dev_resume_manager_db`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: resume_manager_db
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `certification`
--

DROP TABLE IF EXISTS `certification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certification` (
  `date` date DEFAULT NULL,
  `id` bigint NOT NULL,
  `resume_id` bigint DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Certification_Resume` (`resume_id`),
  CONSTRAINT `FK_Certification_Resume` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certification`
--

LOCK TABLES `certification` WRITE;
/*!40000 ALTER TABLE `certification` DISABLE KEYS */;
INSERT INTO `certification` VALUES ('2011-01-01',1,1,'University of Wisconsin, Madison','Master Certificate in Project Management');
/*!40000 ALTER TABLE `certification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certification_seq`
--

DROP TABLE IF EXISTS `certification_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certification_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certification_seq`
--

LOCK TABLES `certification_seq` WRITE;
/*!40000 ALTER TABLE `certification_seq` DISABLE KEYS */;
INSERT INTO `certification_seq` VALUES (51);
/*!40000 ALTER TABLE `certification_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `id` bigint NOT NULL,
  `resume_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Education_Resume` (`resume_id`),
  CONSTRAINT `FK_Education_Resume` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,1,'Cardinal Stritch University, Madison WI','Master of Business Administration','2006-06-01','2004-12-01',''),(2,1,'Nizhny Novgorod State Architecture Academy, Nizhny Novgorod, Russia','Bachelor of Science in Civil Engineering and Managemen','1996-07-01','1991-09-01','Graduated with honors (GPA 4.0)');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_seq`
--

DROP TABLE IF EXISTS `education_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_seq`
--

LOCK TABLES `education_seq` WRITE;
/*!40000 ALTER TABLE `education_seq` DISABLE KEYS */;
INSERT INTO `education_seq` VALUES (101);
/*!40000 ALTER TABLE `education_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` bigint NOT NULL,
  `resume_id` bigint DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Job_Resume` (`resume_id`),
  CONSTRAINT `FK_Job_Resume` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,1,'Ford Credit','Remote','Sr. Java Developer','2024-04-01','2021-08-01'),(2,1,'CDW','Madison, WI','Sr. Java Developer','2021-06-01','2015-09-01'),(3,1,'Edgewood College','Madison, WI','Instructor – (Part-time)','2019-07-01','2006-05-01'),(4,1,'American Family Insurance','Madison, WI','Technical Lead / Consultant','2015-09-01','2013-02-01'),(5,1,'CPM HealthGrades','Madison, WI','Director of Database Development and Project Management ','2013-10-01','2010-11-01'),(6,1,'Amazon.com','Madison, WI','Sr. Software Developer / Architect','2010-09-01','2007-05-01'),(7,1,'TDS Telecom','Madison, WI','Technical Lead (3 month contract)','2006-05-01','2007-02-01'),(8,1,'Great Lakes Educational Loan Services Inc.','Madison, WI','Senior Programmer/Analyst','2007-02-01','2005-08-01'),(9,1,'Isthmus Group Inc.','Madison, WI','IT Consultant','2005-08-01','2004-12-01'),(10,1,'US Cellular.','Madison, WI','Programmer Analyst ','2004-12-01','2002-02-01'),(11,1,'Aesention','Madison, WI','Web Developer','2002-02-01','2000-11-01'),(12,1,'Promstroy Construction Ltd','Nizhny Novgorod, Russia','Project Manager','2000-08-01','1996-06-01');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_responsibility`
--

DROP TABLE IF EXISTS `job_responsibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_responsibility` (
  `id` bigint NOT NULL,
  `job_id` bigint DEFAULT NULL,
  `text` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Job_responsibility_Job` (`job_id`),
  CONSTRAINT `FK_Job_responsibility_Job` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_responsibility`
--

LOCK TABLES `job_responsibility` WRITE;
/*!40000 ALTER TABLE `job_responsibility` DISABLE KEYS */;
INSERT INTO `job_responsibility` VALUES (1,1,'Developed and maintained several REST API microservices using JSON, Java 11, Spring Boot, Hibernate, JPA and Oracle databases following company Service-Oriented Architecture and Application Design guidelines and coding standards;'),(2,1,'Implemented continuous integration/continuous deployment (CI/CD) environments using GitHub, Jenkins, Docker, and Gradle, ensuring streamlined software delivery processes;'),(3,1,'Used Pivotal Cloud Foundry (PCF) platform to build, deploy and manage applications in Azure cloud environment;'),(4,1,'Ensured code quality and security compliance by utilizing SonarQube, Checkmarx and FOSSA for code analysis, and developed a suite of automated functional/acceptance tests using Postman;'),(5,1,'Built performance/load tests using Apache JMeter and monitored application performance post-enhancements;'),(6,1,'Maintained a legacy Java web application utilizing Servlets, Velocity templates, JavaScript, jQuery, DB2 database, and IBM WebSphere Liberty server;'),(7,1,'Used a variety of APIs and libraries such as Apache Commons, Lombok, Log4j to expedite the development process and avoid code duplication;'),(8,1,'Utilized various design patterns to effectively design software that is easy to support and maintain;'),(9,1,'Worked on migration from ADFS (Active Directory Federation Services) to Azure AD, enhancing authentication and access control mechanisms;'),(10,1,'Participated in building a proof of concept (POC) for deploying services to Google Cloud Platform (GCP) utilizing Google Apigee as an abstraction layer to provide access to backend services;'),(11,1,'Leveraged AWS S3 SDK to efficiently access and store objects in Amazon S3, optimizing data management processes;'),(12,1,'Led the successful adaptation of Agile development practices, including test-driven development, pair programming, iterative development, and continuous integration, resulting in improved software quality and development efficiency;'),(13,1,'Successfully trained team members on Agile practices, fostering a collaborative and efficient working environment;'),(14,1,'Actively participated in project planning and management, providing accurate estimates and status reports to management;'),(15,1,'Organized and led meetings and training sessions, mentoring less experienced developers, conducting design and code reviews, and providing insightful analysis for senior management;'),(16,1,'Provided on-call support, ensuring the reliability and availability of critical systems;'),(17,2,'Worked on a number of projects delivering both new functionality as well as providing maintenance and support for the existing applications;'),(18,2,'Assisted in defining technical requirements and estimating technical tasks;'),(19,2,'Utilized Prime Faces JSF implementation to build responsive UI layer for web based applications. Leveraged Java 8, JPA and Hibernate to store and retrieve information from MS SQL Server databases;'),(20,2,'Developed REST web services to facilitate seamless information exchange between various applications and platforms, including web and mobile;'),(21,2,'Utilized Agile development practices such as test driven development, iterative development, continuous integration. Designed and developed functional testing framework using Arquillian and Selenium. Used Maven and Jenkins to set up continuous integration environment builds. Ensured targeted test coverage using JaCoCo  code coverage reports integrated into Maven builds;'),(22,2,'Redesigned existing functional testing framework using Arquillian, Selenium WebDriver, and JUnit to simplify the process of writing functional tests by testers who may not have solid Java development skills;'),(23,2,'Worked closely with the product owners and customers and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, estimating, as well as developing and testing of the delivered functionality;'),(24,2,'Participated in the hiring process, conducting initial technical screenings over the phone and leading in-person interviews;'),(25,2,'Built automated client presentation builder application for the sales team;'),(26,2,'Collaborated with contractors, conducted code reviews, and provided mentorship to junior developers;'),(27,2,'Provided on-call support for clients, utilizing DynaTrace to document and troubleshoot application issues;'),(28,3,'Instructed continuing education students in Project Management, Advanced Software Development with Java, and IT Leadership classes'),(29,3,'Developed comprehensive coursework materials, including defining core learning objectives, creating key class deliverables, establishing grading criteria, outlining class schedules, designing homework assignments, and selecting discussion topics'),(30,3,'Conducted thorough evaluation of student homework, assigned grades, and provided detailed feedback to facilitate student learning and growth'),(31,4,'Led technical implementation of a large development project to build a new rating service for auto insurance. Worked closely with the project manager and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, work planning and scheduling, as well as monitoring and controlling of the project work'),(32,4,'Reviewed technical requirements, provided estimates, facilitated issue resolution, coordinated work for developers, and ensured that software development best practices were followed. Conducted code reviews, mentored less experienced developers'),(33,4,'Played a key role in managing a major upgrade initiative from Java 4 to Java 6, ensuring smooth transition and compatibility with existing systems.'),(34,4,'Developed a new web application testing framework utilizing Selenium, WebDriver, Maven, and Spring frameworks, simplifying the process of writing functional tests for testers with varying levels of Java development skills'),(35,4,'Helped troubleshoot issues related to Guidewire PolicyCenter environment configuration and work with various teams to ensure prompt resolution'),(36,4,'Coordinated work with outside vendors for security assessments and load and penetration testing'),(37,5,'Performed daily management tasks for the database development team that consistent of 22 database developers, analysts, and project managers including: hiring, training, promoting, and taking disciplinary actions when necessary'),(38,5,'Established internal support process for internal business partners (account management team, product managers, help desk, etc.) which provided a clear and convenient way for the rest of the company to reports miscellaneous problems and issues as well as to submit information requests, conducted company-wide training for the employees to ensure the process is being correctly used'),(39,5,'Performed analysis of the existing processes and implemented incremental process improvements including introduction of new processes, new org structure'),(40,5,'Managed several key projects and created project charters, developed project plans and schedules, led cross-department project teams, managed project risks and issues, and provided senior management with weekly status reports'),(41,5,'Helped established project management as a discipline; created original job descriptions for project coordinators and project managers, formally defined the project management framework including all of the core documents and guidelines for the project managers and project coordinators, developed new employee training program for project coordinators'),(42,5,'Developed new employee training program for project coordinators and project managers'),(43,5,'Helped managing the integration between the two offices (Madison and Denver).  Identified the road blocks and acted as a liaison between senior managers in both offices facilitating the process'),(44,5,'Personally managed a number of internal and client facing projects from beginning to end'),(45,6,'Worked for a wholly owned Amazon.com subsidiary (ShopBop), contributing to the successful delivery of multiple projects in various capacities such as technical lead, Java architect, project manager, and QA testing lead'),(46,6,'Played integral roles in projects from requirements gathering and initial analysis to project planning and execution'),(47,6,'Developed project plans, defined schedules, managed risks and issues, led status meetings, and handled internal communication with senior management to ensure project success'),(48,6,'Led successful implementation of multiple projects working with various business clients and ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews'),(49,6,'Helped establishing on-call support processes and infrastructure including defining SLAs for various types of issues'),(50,6,'Designed new architecture for Shopbop.com web site utilizing WebWork and Spring frameworks. Helped integrating web site with Blue Martini e-commerce software. Introduced automated build and continuous integration environments using Maven and Continuum'),(51,6,'Helped establishing testing processes and procedures for QA team including setting up automated test environment, integrating it with build process, and trained testers on how to write automated functional tests using IBM Rational Functional Tester (RFT). '),(52,6,'Fully designed a new framework for writing automated functional tests based on JUnit and Selenium that reduced the duration of QA test cycle from several days to several hours'),(53,7,'Led a cross-functional team of eight software developers and system administrators. Planed the project timeline and resources.'),(54,7,'Managed the workload for individual team members, identified individual goals and objectives. Assessed project risks and identify the mitigation strategies. Maintained the communication between project stakeholders. '),(55,7,'Ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews. Prepared the implementation plans and schedules. Performed post project analysis.'),(56,8,'Led a cross-functional team of five software developers and analysts. Established the common vision and directions for the team. Planed the project timeline and resources. Managed the workload for individual team members, identified individual goals and objectives. Assessed project risks and identify the mitigation strategies. Maintained the communication between project stakeholders. Ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews. Prepared the implementation plans and schedules. Performed post project analysis.'),(57,8,'As a member of enterprise architecture committee participated in identifying the strategic direction for the IS department. Helped creating the company wide standards and development guidelines. Performed analyses on various subjects and presented the results for senior management.'),(58,8,'Planed, organize, and lead a range of trainings and seminars on different aspects of software development process. Mentored and provide guidelines and directions for junior team members. Led code review sessions and system design discussions. Organized and facilitated regular team meetings dedicated to the technical issues and resolutions.'),(59,9,'Led an integration project for IBM Web Sphere Portal and Liferay portal server with custom content management module. Developed custom portlets, themes, and skins'),(60,9,'Provided expertise for both management and clients on various aspects of content management system development'),(61,9,'Planned, organized, and led training sessions for company management and co-workers'),(62,10,'Fully designed and developed multiple intranet based web sites from the ground up'),(63,10,'Implemented the first .NET based intranet web site in the company'),(64,10,'Advised management on various web development areas'),(65,10,'Worked with the cross-functional team of developers, testers, and designers located in Madison and Chicago'),(66,11,'Led successful implementation of multiple e-commerce web applications using various server-side scripting languages and RDBMS.'),(67,11,'Fully designed and developed number of web applications from the ground up'),(68,11,'Mentored web designers on various server-side technologies.'),(69,12,'Led and organized work processes on multiple construction sites. Managed the communication process and served as a single point of contact for the customers and subcontractors'),(70,12,'Organized and coordinated work of multiple organizations involved in the construction process'),(71,12,'Produced technical and financial documentation in accordance with the local laws and government regulations');
/*!40000 ALTER TABLE `job_responsibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_responsibility_seq`
--

DROP TABLE IF EXISTS `job_responsibility_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_responsibility_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_responsibility_seq`
--

LOCK TABLES `job_responsibility_seq` WRITE;
/*!40000 ALTER TABLE `job_responsibility_seq` DISABLE KEYS */;
INSERT INTO `job_responsibility_seq` VALUES (151);
/*!40000 ALTER TABLE `job_responsibility_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_seq`
--

DROP TABLE IF EXISTS `job_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_seq`
--

LOCK TABLES `job_seq` WRITE;
/*!40000 ALTER TABLE `job_seq` DISABLE KEYS */;
INSERT INTO `job_seq` VALUES (101);
/*!40000 ALTER TABLE `job_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendation`
--

DROP TABLE IF EXISTS `recommendation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendation` (
  `id` bigint NOT NULL,
  `resume_id` bigint DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `author_title` varchar(255) DEFAULT NULL,
  `relationship` varchar(255) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `linked_in_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Recommendation_Resume` (`resume_id`),
  CONSTRAINT `FK_Recommendation_Resume` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendation`
--

LOCK TABLES `recommendation` WRITE;
/*!40000 ALTER TABLE `recommendation` DISABLE KEYS */;
INSERT INTO `recommendation` VALUES (1,1,'One of the most desirable characteristics in an employee is someone who takes complete ownership of the problem they are working on. It is very rare to find, but Alex had this in spades. I don\'t think a week went by without Alex knocking on my door with a new idea on how to improve the work we were doing and our company. Alex was asked to implement most of his ideas immediately and he made significant improvements to the processes and project management around our CRM database build projects. Communication and transparency with clients improved dramatically and I received several compliments regarding the improvements. When I declined to implement one of Alex\'s ideas he accepted my decision without issue. He was a joy to work with. I would hire Alex again without reservation.','Erick Hallick','Executive VP of Operations @ CPM Healthgrades','Managed Alexander directly','Erick-Hallick-Avatar-150x150.jpg','https://www.linkedin.com/in/erick-hallick-498a8a5/'),(2,1,'Alex is focused and has a strategic approach to project management, which resulted in success deliverables assigned as part of the App migration program. Alex had shown responsiveness for the projects that he is responsible from end to end. During the App migration, program implementation I had pleasure to collaborate around agile principles, scrum framework including best project practices to ensure success of each other deliverables. He had shown great technical acumen that the project team members ran brainstorming ideas with him around challenges and blockers. Alex showed great people skills on how to motivate people or dial back when great necessary to make sure that project is completed on time. Alex would be great asset to any team.','Aditya Prakash','Project Manager @ American Family Insurance','Worked with Alexander on the same team','Aditya-Prakash-Avatar-150x150.jpg','https://www.linkedin.com/in/aditya-prakash-csm/'),(3,1,'Alex is one of the best managers I have had the pleasure to work for. He truly believes it is his responsibility to look out for his team and to remove obstacles so that they may succeed, as well as ensure that objectives are accomplished. When I started with CPM there was an environmental issue that was affecting my performance, and while Alex could not eliminate the issue he did come up with ways to mitigate it and he followed up to see if there was an improvement. Alex lead the expansion of the development team, doubling its size; and he also created a project management team. Through all of this, Alex kept a sense of humor and helped everyone on the teams manage heavy workloads and tight deadlines. I\'ve enjoyed working for Alex and look forward to more opportunities to do so.','Jeff Fletcher','Sr. Database Developer @ CPM Healthgrades','Reported directly to Alexander','Jeff-Fletcher-Avatar-150x150.jpg','https://www.linkedin.com/in/jeff-fletcher-01b5b44/');
/*!40000 ALTER TABLE `recommendation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendation_seq`
--

DROP TABLE IF EXISTS `recommendation_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendation_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendation_seq`
--

LOCK TABLES `recommendation_seq` WRITE;
/*!40000 ALTER TABLE `recommendation_seq` DISABLE KEYS */;
INSERT INTO `recommendation_seq` VALUES (101);
/*!40000 ALTER TABLE `recommendation_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reference`
--

DROP TABLE IF EXISTS `reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reference` (
  `id` bigint NOT NULL,
  `resume_id` bigint DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_Resume` (`resume_id`),
  CONSTRAINT `FK_Reference_Resume` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
INSERT INTO `reference` VALUES (1,1,'erick@hallick.com','Erick Hallick','555-555-5555','Executive VP of Operations @ CPM Healthgrades'),(2,1,'Aditya@Prakash.com','Aditya Prakash','555-555-5555','Project Manager @ American Family Insurance'),(3,1,'Jeff@Fletcher.com','Jeff Fletcher','555-555-5555','Sr. Database Developer @ CPM Healthgrades');
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reference_seq`
--

DROP TABLE IF EXISTS `reference_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reference_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference_seq`
--

LOCK TABLES `reference_seq` WRITE;
/*!40000 ALTER TABLE `reference_seq` DISABLE KEYS */;
INSERT INTO `reference_seq` VALUES (101);
/*!40000 ALTER TABLE `reference_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resume` (
  `id` bigint NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `objective` varchar(500) DEFAULT NULL,
  `summary` varchar(1000) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zip` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (1,'Alexander','Garbuz','Looking for leadership position in a technology driven organization where I can utilize my problem solving, mentoring and communication skills.','Senior IT professional with more than 25 years of combined software development, leadership and management experience in insurance, healthcare, telecommunications, and e-commerce industries','405 Burnt Sienna Dr.','Middleton','alexander.garbuz@gmail.com','608-628-2448','WI','53562');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume_seq`
--

DROP TABLE IF EXISTS `resume_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resume_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume_seq`
--

LOCK TABLES `resume_seq` WRITE;
/*!40000 ALTER TABLE `resume_seq` DISABLE KEYS */;
INSERT INTO `resume_seq` VALUES (51);
/*!40000 ALTER TABLE `resume_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `id` bigint NOT NULL,
  `skill_group_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SKill_Skill_Group` (`skill_group_id`),
  CONSTRAINT `FK_SKill_Skill_Group` FOREIGN KEY (`skill_group_id`) REFERENCES `skill_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,1,'Java'),(2,1,' PHP'),(3,1,' SQL'),(4,1,' HTML'),(5,1,' XML'),(6,1,' XSL'),(7,1,' CSS'),(8,1,' JavaScript'),(9,1,' CFML'),(10,1,' UML'),(11,2,'REST API'),(12,2,' API Gateways'),(13,2,' J2EE'),(14,2,' JSP'),(15,2,' Servlets'),(16,2,' JPA'),(17,2,' JDBC'),(18,3,'Microsoft SQL'),(19,3,' Oracle'),(20,3,' DB2'),(21,3,' MySQL'),(22,4,'Microsoft Windows'),(23,4,' Linux'),(24,5,'IIS'),(25,5,' Apache'),(26,5,' Tomcat'),(27,5,' WildFly'),(28,5,' IBM WebSphere Liberty'),(29,6,'Spring'),(30,6,' Spring Boot'),(31,6,' Struts'),(32,6,' Hibernate'),(33,6,' JUnit'),(34,6,' Apache Cactus'),(35,6,' EasyMock'),(36,6,' Mockito'),(37,6,' Selenium'),(38,6,' Arquillian'),(39,6,' jQuery'),(40,7,'Maven'),(41,7,' Ant'),(42,7,' Gradle'),(43,7,' Jenkins'),(44,7,' Docker'),(45,7,' AWS'),(46,7,' Subversion'),(47,7,' GitHub'),(48,7,' Eclipse'),(49,7,' IntelliJ IDEA'),(50,7,' Apache JMeter'),(51,8,'Agile'),(52,8,' Extreme programming'),(53,8,' Scrum'),(54,8,' Kanban');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_group`
--

DROP TABLE IF EXISTS `skill_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_group` (
  `id` bigint NOT NULL,
  `resume_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SKill_Group_Resume` (`resume_id`),
  CONSTRAINT `FK_SKill_Group_Resume` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_group`
--

LOCK TABLES `skill_group` WRITE;
/*!40000 ALTER TABLE `skill_group` DISABLE KEYS */;
INSERT INTO `skill_group` VALUES (1,1,'Languages'),(2,1,'Technologies'),(3,1,'Databases'),(4,1,'OS'),(5,1,'Servers'),(6,1,'Frameworks'),(7,1,'Tools'),(8,1,'Methodologies');
/*!40000 ALTER TABLE `skill_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_group_seq`
--

DROP TABLE IF EXISTS `skill_group_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_group_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_group_seq`
--

LOCK TABLES `skill_group_seq` WRITE;
/*!40000 ALTER TABLE `skill_group_seq` DISABLE KEYS */;
INSERT INTO `skill_group_seq` VALUES (101);
/*!40000 ALTER TABLE `skill_group_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_seq`
--

DROP TABLE IF EXISTS `skill_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_seq`
--

LOCK TABLES `skill_seq` WRITE;
/*!40000 ALTER TABLE `skill_seq` DISABLE KEYS */;
INSERT INTO `skill_seq` VALUES (151);
/*!40000 ALTER TABLE `skill_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-28 17:04:33
