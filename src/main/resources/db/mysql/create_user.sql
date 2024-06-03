CREATE DATABASE IF NOT EXISTS resume_manager_db;

ALTER DATABASE resume_manager_db 
DEFAULT CHARACTER SET utf8 
DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON resume_manager_db.* TO 'resume_user'@'%' IDENTIFIED BY 'resume_password';