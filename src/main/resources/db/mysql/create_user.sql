DROP SCHEMA IF EXISTS resume_manager_db;
CREATE SCHEMA resume_manager_db;
USE resume_manager_db;

ALTER DATABASE resume_manager_db 
DEFAULT CHARACTER SET utf8 
DEFAULT COLLATE utf8_general_ci;

CREATE USER 'resume_user'@'%' IDENTIFIED BY 'resume_password';

GRANT ALL PRIVILEGES ON resume_manager_db.* TO 'resume_user'@'%';