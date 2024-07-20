DROP SCHEMA IF EXISTS dev_resume_manager_db;
CREATE SCHEMA dev_resume_manager_db;
USE dev_resume_manager_db;

ALTER DATABASE dev_resume_manager_db 
DEFAULT CHARACTER SET utf8 
DEFAULT COLLATE utf8_general_ci;

CREATE USER  IF NOT EXISTS 'dev_resume_user'@'%' IDENTIFIED BY 'dev_resume_password';

GRANT ALL PRIVILEGES ON dev_resume_manager_db.* TO 'dev_resume_user'@'%';