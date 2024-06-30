use resume_manager_db;

ALTER TABLE recommendation
ADD COLUMN avatar_url VARCHAR(255) DEFAULT NULL,
ADD COLUMN linked_in_url VARCHAR(255) DEFAULT NULL;

UPDATE recommendation set avatar_url = 'Erick-Hallick-Avatar-150x150.jpg' AND linked_in_url='https://www.linkedin.com/in/erick-hallick-498a8a5/' where id=1;
UPDATE recommendation set avatar_url = 'Aditya-Prakash-Avatar-150x150.jpg' AND linked_in_url='https://www.linkedin.com/in/aditya-prakash-csm/' where id=2;
UPDATE recommendation set avatar_url = 'Jeff-Fletcher-Avatar-150x150.jpg' AND linked_in_url='https://www.linkedin.com/in/jeff-fletcher-01b5b44/' where id=3;

SELECT * FROM resume_manager_db.recommendation;