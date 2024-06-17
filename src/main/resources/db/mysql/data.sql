
USE resume_manager_db;

INSERT INTO resume_seq VALUES (51);
INSERT INTO certification_seq VALUES (51);
INSERT INTO contact_information_seq VALUES (51);
INSERT INTO summary_seq VALUES (51);
INSERT INTO education_seq VALUES (101);
INSERT INTO job_responsibility_seq VALUES (151);
INSERT INTO job_seq VALUES (101);
INSERT INTO recommendation_seq VALUES (101);
INSERT INTO reference_seq VALUES (101);
INSERT INTO skill_group_seq VALUES (101);
INSERT INTO skill_seq VALUES (151);

INSERT INTO resume VALUES (1,'Alexander','Garbuz');

INSERT INTO certification VALUES ('2011-01-01',1,1,'University of Wisconsin, Madison','Master Certificate in Project Management');

INSERT INTO contact_information VALUES (1,1,'405 Burnt Sienna Dr.','Middleton','alexander.garbuz@gmail.com','608-628-2448','WI','53562');

INSERT INTO summary VALUES (1,1,'Looking for leadership position in a technology driven organization where I can utilize my problem solving, mentoring and communication skills.','Senior IT professional with more than 25 years of combined software development, leadership and management experience in insurance, healthcare, telecommunications, and e-commerce industries');

INSERT INTO education VALUES ('2006-06-01','2004-12-01',1,1,'','Master of Business Administration','Cardinal Stritch University, Madison WI');
INSERT INTO education VALUES ('1996-07-01','1991-09-01',2,1,'Graduated with honors (GPA 4.0)','Bachelor of Science in Civil Engineering and Managemen','Nizhny Novgorod State Architecture Academy, Nizhny Novgorod, Russia');


INSERT INTO job VALUES ('2024-04-01','2021-08-01',1,1,'Ford Credit','Remote','Sr. Java Developer / Consultant');
INSERT INTO job VALUES ('2021-06-01','2015-09-01',2,1,'CDW','Madison, WI','Sr. Java Developer');
INSERT INTO job VALUES ('2019-07-01','2006-05-01',3,1,'Edgewood College','Madison, WI','Instructor – (Part-time)');
INSERT INTO job VALUES ('2015-09-01','2013-02-01',4,1,'American Family Insurance','Madison, WI','Technical Lead / Consultant');
INSERT INTO job VALUES ('2013-10-01','2010-11-01',5,1,'CPM HealthGrades','Madison, WI','Director of Database Development and Project Management ');
INSERT INTO job VALUES ('2010-09-01','2007-05-01',6,1,'Amazon.com','Madison, WI','Sr. Software Developer / Architect');
INSERT INTO job VALUES ('2006-05-01','2007-02-01',7,1,'TDS Telecom','Madison, WI','Technical Lead (3 month contract)');
INSERT INTO job VALUES ('2007-02-01','2005-08-01',8,1,'Great Lakes Educational Loan Services Inc.','Madison, WI','Senior Programmer/Analyst');
INSERT INTO job VALUES ('2005-08-01','2004-12-01',9,1,'Isthmus Group Inc.','Madison, WI','IT Consultant');
INSERT INTO job VALUES ('2004-12-01','2002-02-01',10,1,'US Cellular.','Madison, WI','Programmer Analyst ');
INSERT INTO job VALUES ('2002-02-01','2000-11-01',11,1,'Aesention','Madison, WI','Web Developer');
INSERT INTO job VALUES ('2000-08-01','1996-06-01',12,1,'Promstroy Construction Ltd','Nizhny Novgorod, Russia','Project Manager');

INSERT INTO job_responsibility VALUES (1,1,'Developed and maintained a number of micro-services using Spring Boot and Oracle. Helped the team to migrate from ADFS (Active Directory Federation Service) to Azure AD; Participated in building POC for deploying services to GCP (Google Could Platform) utilizing Google Apigee platform as abstraction layer to provide access to backend service. Used S3 SDK to access and store objects in AWS storage;');
INSERT INTO job_responsibility VALUES (2,1,'Led successful adaptation of Agile development practices such as test driven development, pair programming, iterative development, and continuous integration. Used GitHub, Jenkins, and Gradle to implement continuous integration/continues deployment environment. Utilized Checkmarx and FOSSA to ensure code quality and security compliance. Developed a suite of automated functional/acceptance tests using Postman. Built performance/load tests using Apache JMeter. Ensured targeted test coverage using JaCoCo code coverage reports;');
INSERT INTO job_responsibility VALUES (3,1,'Maintained legacy Java web application utilizing Servlets, Velocity templates, jQuery, DB2 and IBM WebSphere Liberty server;');
INSERT INTO job_responsibility VALUES (4,1,'Actively participated in project planning and management, created estimates, and provided status reports to management. Planned, organized and led meetings and training sessions. Mentored less experienced developers, conducted design and code reviews, performed analysis for senior management;');
INSERT INTO job_responsibility VALUES (5,1,'Provided on-call support;');
INSERT INTO job_responsibility VALUES (6,2,'Worked on a number of projects delivering both new functionality as well as providing maintenance and support for the existing applications;');
INSERT INTO job_responsibility VALUES (7,2,'Helped define technical requirements and estimated assigned tasks. Used JPA and Hibernate to store and retrieve information from MS SQL Server databases. Used Prime Faces JSF implementation to build responsive UI layer for web based applications.');
INSERT INTO job_responsibility VALUES (8,2,'Developed a number of RESTful web services to share information between multiple applications and platforms (web and mobile);');
INSERT INTO job_responsibility VALUES (9,2,'Utilized Agile development practices such as test driven development, iterative development, continuous integration. Designed and developed functional testing framework using Arquillian and Selenium. Used Maven and Jenkins to set up continuous integration environment builds. Ensured targeted test coverage using JaCoCo code coverage reports integrated into Maven builds;');
INSERT INTO job_responsibility VALUES (10,2,'Worked closely with the product owners and customers and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, estimating, as well as developing and testing of the delivered functionality;');
INSERT INTO job_responsibility VALUES (11,2,'Participated in the hiring process, perform initial technical screening on the phone and conduct in-person interviews;');
INSERT INTO job_responsibility VALUES (12,2,'Worked with contractors, conducted code reviews, mentored less experienced developers;');
INSERT INTO job_responsibility VALUES (13,2,'Provided on-call support for the clients. Used DynaTrace to document and troubleshoot issues with the applications we supported.');
INSERT INTO job_responsibility VALUES (14,3,'Instructed continuing education students in Project Management, Advanced Software Development with Java, and IT Leadership classes');
INSERT INTO job_responsibility VALUES (15,3,'Developed comprehensive coursework materials, including defining core learning objectives, creating key class deliverables, establishing grading criteria, outlining class schedules, designing homework assignments, and selecting discussion topics');
INSERT INTO job_responsibility VALUES (16,3,'Conducted thorough evaluation of student homework, assigned grades, and provided detailed feedback to facilitate student learning and growth');
INSERT INTO job_responsibility VALUES (17,4,'Led technical implementation of a large development project to build a new rating service for auto insurance. Worked closely with the project manager and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, work planning and scheduling, as well as monitoring and controlling of the project work');
INSERT INTO job_responsibility VALUES (18,4,'Reviewed technical requirements, provided estimates, facilitated issue resolution, coordinated work for developers, and ensured that software development best practices were followed. Conducted code reviews, mentored less experienced developers');
INSERT INTO job_responsibility VALUES (19,4,'Played a key role in managing a major upgrade initiative from Java 4 to Java 6, ensuring smooth transition and compatibility with existing systems.');
INSERT INTO job_responsibility VALUES (20,4,'Developed a new web application testing framework utilizing Selenium, WebDriver, Maven, and Spring frameworks, simplifying the process of writing functional tests for testers with varying levels of Java development skills');
INSERT INTO job_responsibility VALUES (21,4,'Helped troubleshoot issues related to Guidewire PolicyCenter environment configuration and work with various teams to ensure prompt resolution');
INSERT INTO job_responsibility VALUES (22,4,'Coordinated work with outside vendors for security assessments and load and penetration testing');
INSERT INTO job_responsibility VALUES (23,5,'Performed daily management tasks for the database development team that consistent of 22 database developers, analysts, and project managers including: hiring, training, promoting, and taking disciplinary actions when necessary');
INSERT INTO job_responsibility VALUES (24,5,'Established internal support process for internal business partners (account management team, product managers, help desk, etc.) which provided a clear and convenient way for the rest of the company to reports miscellaneous problems and issues as well as to submit information requests, conducted company-wide training for the employees to ensure the process is being correctly used');
INSERT INTO job_responsibility VALUES (25,5,'Performed analysis of the existing processes and implemented incremental process improvements including introduction of new processes, new org structure');
INSERT INTO job_responsibility VALUES (26,5,'Managed several key projects and created project charters, developed project plans and schedules, led cross-department project teams, managed project risks and issues, and provided senior management with weekly status reports');
INSERT INTO job_responsibility VALUES (27,5,'Helped established project management as a discipline; created original job descriptions for project coordinators and project managers, formally defined the project management framework including all of the core documents and guidelines for the project managers and project coordinators, developed new employee training program for project coordinators');
INSERT INTO job_responsibility VALUES (28,5,'Developed new employee training program for project coordinators and project managers');
INSERT INTO job_responsibility VALUES (29,5,'Helped managing the integration between the two offices (Madison and Denver).  Identified the road blocks and acted as a liaison between senior managers in both offices facilitating the process');
INSERT INTO job_responsibility VALUES (30,5,'Personally managed a number of internal and client facing projects from beginning to end');
INSERT INTO job_responsibility VALUES (31,6,'Worked for a wholly owned Amazon.com subsidiary (ShopBop), contributing to the successful delivery of multiple projects in various capacities such as technical lead, Java architect, project manager, and QA testing lead');
INSERT INTO job_responsibility VALUES (32,6,'Played integral roles in projects from requirements gathering and initial analysis to project planning and execution');
INSERT INTO job_responsibility VALUES (33,6,'Developed project plans, defined schedules, managed risks and issues, led status meetings, and handled internal communication with senior management to ensure project success');
INSERT INTO job_responsibility VALUES (34,6,'Led successful implementation of multiple projects working with various business clients and ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews');
INSERT INTO job_responsibility VALUES (35,6,'Helped establishing on-call support processes and infrastructure including defining SLAs for various types of issues');
INSERT INTO job_responsibility VALUES (36,6,'Designed new architecture for Shopbop.com web site utilizing WebWork and Spring frameworks. Helped integrating web site with Blue Martini e-commerce software. Introduced automated build and continuous integration environments using Maven and Continuum');
INSERT INTO job_responsibility VALUES (37,6,'Helped establishing testing processes and procedures for QA team including setting up automated test environment, integrating it with build process, and trained testers on how to write automated functional tests using IBM Rational Functional Tester (RFT). ');
INSERT INTO job_responsibility VALUES (38,6,'Fully designed a new framework for writing automated functional tests based on JUnit and Selenium that reduced the duration of QA test cycle from several days to several hours');
INSERT INTO job_responsibility VALUES (39,7,'Led a cross-functional team of eight software developers and system administrators. Planed the project timeline and resources.');
INSERT INTO job_responsibility VALUES (40,7,'Managed the workload for individual team members, identified individual goals and objectives. Assessed project risks and identify the mitigation strategies. Maintained the communication between project stakeholders. ');
INSERT INTO job_responsibility VALUES (41,7,'Ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews. Prepared the implementation plans and schedules. Performed post project analysis.');
INSERT INTO job_responsibility VALUES (42,8,'Led a cross-functional team of five software developers and analysts. Established the common vision and directions for the team. Planed the project timeline and resources. Managed the workload for individual team members, identified individual goals and objectives. Assessed project risks and identify the mitigation strategies. Maintained the communication between project stakeholders. Ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews. Prepared the implementation plans and schedules. Performed post project analysis.');
INSERT INTO job_responsibility VALUES (43,8,'As a member of enterprise architecture committee participated in identifying the strategic direction for the IS department. Helped creating the company wide standards and development guidelines. Performed analyses on various subjects and presented the results for senior management.');
INSERT INTO job_responsibility VALUES (44,8,'Planed, organize, and lead a range of trainings and seminars on different aspects of software development process. Mentored and provide guidelines and directions for junior team members. Led code review sessions and system design discussions. Organized and facilitated regular team meetings dedicated to the technical issues and resolutions.');
INSERT INTO job_responsibility VALUES (45,9,'Led an integration project for IBM Web Sphere Portal and Liferay portal server with custom content management module. Developed custom portlets, themes, and skins');
INSERT INTO job_responsibility VALUES (46,9,'Provided expertise for both management and clients on various aspects of content management system development');
INSERT INTO job_responsibility VALUES (47,9,'Planned, organized, and led training sessions for company management and co-workers');
INSERT INTO job_responsibility VALUES (48,10,'Fully designed and developed multiple intranet based web sites from the ground up');
INSERT INTO job_responsibility VALUES (49,10,'Implemented the first .NET based intranet web site in the company');
INSERT INTO job_responsibility VALUES (50,10,'Advised management on various web development areas');
INSERT INTO job_responsibility VALUES (51,10,'Worked with the cross-functional team of developers, testers, and designers located in Madison and Chicago');
INSERT INTO job_responsibility VALUES (52,11,'Led successful implementation of multiple e-commerce web applications using various server-side scripting languages and RDBMS.');
INSERT INTO job_responsibility VALUES (53,11,'Fully designed and developed number of web applications from the ground up');
INSERT INTO job_responsibility VALUES (54,11,'Mentored web designers on various server-side technologies.');
INSERT INTO job_responsibility VALUES (55,12,'Led and organized work processes on multiple construction sites. Managed the communication process and served as a single point of contact for the customers and subcontractors');
INSERT INTO job_responsibility VALUES (56,12,'Organized and coordinated work of multiple organizations involved in the construction process');
INSERT INTO job_responsibility VALUES (57,12,'Produced technical and financial documentation in accordance with the local laws and government regulations');


INSERT INTO recommendation VALUES (1,1,'One of the most desirable characteristics in an employee is someone who takes complete ownership of the problem they are working on. It is very rare to find, but Alex had this in spades. I don\'t think a week went by without Alex knocking on my door with a new idea on how to improve the work we were doing and our company. Alex was asked to implement most of his ideas immediately and he made significant improvements to the processes and project management around our CRM database build projects. Communication and transparency with clients improved dramatically and I received several compliments regarding the improvements. When I declined to implement one of Alex\'s ideas he accepted my decision without issue. He was a joy to work with. I would hire Alex again without reservation.','Erick Hallick','Executive VP of Operations @ CPM Healthgrades','Managed Alexander directly');
INSERT INTO recommendation VALUES (2,1,'Alex is focused and has a strategic approach to project management, which resulted in success deliverables assigned as part of the App migration program. Alex had shown responsiveness for the projects that he is responsible from end to end. During the App migration, program implementation I had pleasure to collaborate around agile principles, scrum framework including best project practices to ensure success of each other deliverables. He had shown great technical acumen that the project team members ran brainstorming ideas with him around challenges and blockers. Alex showed great people skills on how to motivate people or dial back when great necessary to make sure that project is completed on time. Alex would be great asset to any team.','Aditya Prakash','Project Manager @ American Family Insurance','Worked with Alexander on the same team');
INSERT INTO recommendation VALUES (3,1,'Alex is one of the best managers I have had the pleasure to work for. He truly believes it is his responsibility to look out for his team and to remove obstacles so that they may succeed, as well as ensure that objectives are accomplished. When I started with CPM there was an environmental issue that was affecting my performance, and while Alex could not eliminate the issue he did come up with ways to mitigate it and he followed up to see if there was an improvement. Alex lead the expansion of the development team, doubling its size; and he also created a project management team. Through all of this, Alex kept a sense of humor and helped everyone on the teams manage heavy workloads and tight deadlines. I\'ve enjoyed working for Alex and look forward to more opportunities to do so.','Jeff Fletcher','Sr. Database Developer @ CPM Healthgrades','Reported directly to Alexander');

INSERT INTO reference VALUES (1,1,'erick@hallick.com','Erick Hallick','555-555-5555','Executive VP of Operations @ CPM Healthgrades');
INSERT INTO reference VALUES (2,1,'Aditya@Prakash.com','Aditya Prakash','555-555-5555','Project Manager @ American Family Insurance');
INSERT INTO reference VALUES (3,1,'Jeff@Fletcher.com','Jeff Fletcher','555-555-5555','Sr. Database Developer @ CPM Healthgrades');


INSERT INTO skill_group VALUES (1,1,'Languages');
INSERT INTO skill_group VALUES (2,1,'Technologies');
INSERT INTO skill_group VALUES (3,1,'Databases');
INSERT INTO skill_group VALUES (4,1,'OS');
INSERT INTO skill_group VALUES (5,1,'Servers');
INSERT INTO skill_group VALUES (6,1,'Frameworks');
INSERT INTO skill_group VALUES (7,1,'Tools');

INSERT INTO skill VALUES (1,1,'Java');
INSERT INTO skill VALUES (2,1,' C#');
INSERT INTO skill VALUES (3,1,' Visual Basic');
INSERT INTO skill VALUES (4,1,' Visual Basic .NET');
INSERT INTO skill VALUES (5,1,' PHP');
INSERT INTO skill VALUES (6,1,' HTML/DHTML');
INSERT INTO skill VALUES (7,1,' XML/XSL');
INSERT INTO skill VALUES (8,1,' SQL');
INSERT INTO skill VALUES (9,1,' CSS');
INSERT INTO skill VALUES (10,1,' JavaScript');
INSERT INTO skill VALUES (11,1,' VBScript');
INSERT INTO skill VALUES (12,1,' CFML');
INSERT INTO skill VALUES (13,1,' UML');
INSERT INTO skill VALUES (14,2,'J2EE');
INSERT INTO skill VALUES (15,2,' JSP');
INSERT INTO skill VALUES (16,2,' Servlets');
INSERT INTO skill VALUES (17,2,' JavaBeans');
INSERT INTO skill VALUES (18,2,' JDBC');
INSERT INTO skill VALUES (19,2,' EJB');
INSERT INTO skill VALUES (20,2,' ASP');
INSERT INTO skill VALUES (21,2,' ASP.NET');
INSERT INTO skill VALUES (22,2,' CGI');
INSERT INTO skill VALUES (23,2,' ADO');
INSERT INTO skill VALUES (24,2,' ColdFusion');
INSERT INTO skill VALUES (25,3,'Microsoft SQL');
INSERT INTO skill VALUES (26,3,' Oracle');
INSERT INTO skill VALUES (27,3,' DB2');
INSERT INTO skill VALUES (28,3,' MySQL');
INSERT INTO skill VALUES (29,4,'Microsoft Windows');
INSERT INTO skill VALUES (30,4,' Linux');
INSERT INTO skill VALUES (31,5,'IIS');
INSERT INTO skill VALUES (32,5,' Apache');
INSERT INTO skill VALUES (33,5,' Tomcat');
INSERT INTO skill VALUES (34,5,' JBoss WildFly');
INSERT INTO skill VALUES (35,5,' New Atlanta ServletExec');
INSERT INTO skill VALUES (36,5,' JRun');
INSERT INTO skill VALUES (37,5,' WebLogic');
INSERT INTO skill VALUES (38,6,'Struts');
INSERT INTO skill VALUES (39,6,' Spring');
INSERT INTO skill VALUES (40,6,' Spring Boot');
INSERT INTO skill VALUES (41,6,' Hibernate');
INSERT INTO skill VALUES (42,6,' iBATIS SQL Maps');
INSERT INTO skill VALUES (43,6,' iBATIS DAO');
INSERT INTO skill VALUES (44,6,' JUnit');
INSERT INTO skill VALUES (45,6,' Apache Cactus');
INSERT INTO skill VALUES (46,6,' EasyMock');
INSERT INTO skill VALUES (47,6,' Mockito');
INSERT INTO skill VALUES (48,6,' Selenium');
INSERT INTO skill VALUES (49,6,' Arquillian');
INSERT INTO skill VALUES (50,7,'IBM Rational Application Developer (RAD)');
INSERT INTO skill VALUES (51,7,' IBM Web Sphere Application Developer Studio (WSAD)');
INSERT INTO skill VALUES (52,7,' Eclipse');
INSERT INTO skill VALUES (53,7,' IntelliJ IDEA');
INSERT INTO skill VALUES (54,7,' NetBeans');
INSERT INTO skill VALUES (55,7,' iReports');
INSERT INTO skill VALUES (56,7,' VisualCaffe');
INSERT INTO skill VALUES (57,7,' Borland JBuilder');
INSERT INTO skill VALUES (58,7,' Ant');
INSERT INTO skill VALUES (59,7,' Maven');
INSERT INTO skill VALUES (60,7,' Cruise Control');
INSERT INTO skill VALUES (61,7,' Continuum');
INSERT INTO skill VALUES (62,7,' Jenkins');
INSERT INTO skill VALUES (63,7,' Docker');
INSERT INTO skill VALUES (64,7,' AWS');
INSERT INTO skill VALUES (65,7,' Subversion');
INSERT INTO skill VALUES (66,7,' Git');




