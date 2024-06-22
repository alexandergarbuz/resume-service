package com.garbuz.resume.factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.JobResponsibility;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.repository.JobDao;
import com.garbuz.resume.repository.JobResponsibilityDao;

@Component
public class JobFactory {

	private static final Logger LOG = LoggerFactory.getLogger(JobFactory.class);
	
	private JobDao jobDao;
	private JobResponsibilityDao jobResponsibilityDao;
	
	public JobFactory(JobDao jobDao, JobResponsibilityDao jobResponsibilityDao) {
		this.jobDao = jobDao;
		this.jobResponsibilityDao = jobResponsibilityDao;
	}

	public List<Job> createDefaultJobs(final Resume resume) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(createJob(resume, "Sr. Java Developer / Consultant", "Ford Credit", "Remote", LocalDate.of(2021, 8, 1), LocalDate.of(2024, 4, 1),
			new String[] {
				"Developed and maintained a number of micro-services using Spring Boot and Oracle. Helped the team to migrate from ADFS (Active Directory Federation Service) to Azure AD; Participated in building POC for deploying services to GCP (Google Could Platform) utilizing Google Apigee platform as abstraction layer to provide access to backend service. Used S3 SDK to access and store objects in AWS storage;",
				"Led successful adaptation of Agile development practices such as test driven development, pair programming, iterative development, and continuous integration. Used GitHub, Jenkins, and Gradle to implement continuous integration/continues deployment environment. Utilized Checkmarx and FOSSA to ensure code quality and security compliance. Developed a suite of automated functional/acceptance tests using Postman. Built performance/load tests using Apache JMeter. Ensured targeted test coverage using JaCoCo code coverage reports;",
				"Maintained legacy Java web application utilizing Servlets, Velocity templates, jQuery, DB2 and IBM WebSphere Liberty server;",
				"Actively participated in project planning and management, created estimates, and provided status reports to management. Planned, organized and led meetings and training sessions. Mentored less experienced developers, conducted design and code reviews, performed analysis for senior management;", 
				"Provided on-call support;"
		}));
		jobs.add(createJob(resume, "Sr. Java Developer", "CDW", "Madison, WI", LocalDate.of(2015, 9, 1), LocalDate.of(2021, 6, 1),
			new String[] {
				"Worked on a number of projects delivering both new functionality as well as providing maintenance and support for the existing applications;",
				"Helped define technical requirements and estimated assigned tasks. Used JPA and Hibernate to store and retrieve information from MS SQL Server databases. Used Prime Faces JSF implementation to build responsive UI layer for web based applications.",
				"Developed a number of RESTful web services to share information between multiple applications and platforms (web and mobile);",
				"Utilized Agile development practices such as test driven development, iterative development, continuous integration. Designed and developed functional testing framework using Arquillian and Selenium. Used Maven and Jenkins to set up continuous integration environment builds. Ensured targeted test coverage using JaCoCo code coverage reports integrated into Maven builds;",
				"Worked closely with the product owners and customers and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, estimating, as well as developing and testing of the delivered functionality;",
				"Participated in the hiring process, perform initial technical screening on the phone and conduct in-person interviews;",
				"Worked with contractors, conducted code reviews, mentored less experienced developers;",
				"Provided on-call support for the clients. Used DynaTrace to document and troubleshoot issues with the applications we supported."
		}));
		jobs.add(createJob(resume, "Instructor – (Part-time)", "Edgewood College", "Madison, WI", LocalDate.of(2006, 5, 1), LocalDate.of(2019, 7, 1),
				new String[] {
				"Instructed continuing education students in Project Management, Advanced Software Development with Java, and IT Leadership classes",
				"Developed comprehensive coursework materials, including defining core learning objectives, creating key class deliverables, establishing grading criteria, outlining class schedules, designing homework assignments, and selecting discussion topics",
				"Conducted thorough evaluation of student homework, assigned grades, and provided detailed feedback to facilitate student learning and growth"
		}));		
		jobs.add(createJob(resume, "Technical Lead / Consultant", "American Family Insurance", "Madison, WI", LocalDate.of(2013, 2, 1), LocalDate.of(2015, 9, 1),
				new String[] {
				"Led technical implementation of a large development project to build a new rating service for auto insurance. Worked closely with the project manager and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, work planning and scheduling, as well as monitoring and controlling of the project work",
				"Reviewed technical requirements, provided estimates, facilitated issue resolution, coordinated work for developers, and ensured that software development best practices were followed. Conducted code reviews, mentored less experienced developers",
				"Played a key role in managing a major upgrade initiative from Java 4 to Java 6, ensuring smooth transition and compatibility with existing systems.",
				"Developed a new web application testing framework utilizing Selenium, WebDriver, Maven, and Spring frameworks, simplifying the process of writing functional tests for testers with varying levels of Java development skills",
				"Helped troubleshoot issues related to Guidewire PolicyCenter environment configuration and work with various teams to ensure prompt resolution",
				"Coordinated work with outside vendors for security assessments and load and penetration testing"
		}));
		jobs.add(createJob(resume, "Director of Database Development and Project Management ", "CPM HealthGrades", "Madison, WI", LocalDate.of(2010, 11, 1), LocalDate.of(2013, 10, 1),
				new String[] {
				"Performed daily management tasks for the database development team that consistent of 22 database developers, analysts, and project managers including: hiring, training, promoting, and taking disciplinary actions when necessary",
				"Established internal support process for internal business partners (account management team, product managers, help desk, etc.) which provided a clear and convenient way for the rest of the company to reports miscellaneous problems and issues as well as to submit information requests, conducted company-wide training for the employees to ensure the process is being correctly used",
				"Performed analysis of the existing processes and implemented incremental process improvements including introduction of new processes, new org structure",
				"Managed several key projects and created project charters, developed project plans and schedules, led cross-department project teams, managed project risks and issues, and provided senior management with weekly status reports",
				"Helped established project management as a discipline; created original job descriptions for project coordinators and project managers, formally defined the project management framework including all of the core documents and guidelines for the project managers and project coordinators, developed new employee training program for project coordinators",
				"Developed new employee training program for project coordinators and project managers",
				"Helped managing the integration between the two offices (Madison and Denver).  Identified the road blocks and acted as a liaison between senior managers in both offices facilitating the process",
				"Personally managed a number of internal and client facing projects from beginning to end"
		}));
		jobs.add(createJob(resume, "Sr. Software Developer / Architect", "Amazon.com", "Madison, WI", LocalDate.of(2007, 5, 1), LocalDate.of(2010, 9, 1),
				new String[] {
				"Worked for a wholly owned Amazon.com subsidiary (ShopBop), contributing to the successful delivery of multiple projects in various capacities such as technical lead, Java architect, project manager, and QA testing lead",
				"Played integral roles in projects from requirements gathering and initial analysis to project planning and execution",
				"Developed project plans, defined schedules, managed risks and issues, led status meetings, and handled internal communication with senior management to ensure project success",
				"Led successful implementation of multiple projects working with various business clients and ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews",
				"Helped establishing on-call support processes and infrastructure including defining SLAs for various types of issues",
				"Designed new architecture for Shopbop.com web site utilizing WebWork and Spring frameworks. Helped integrating web site with Blue Martini e-commerce software. Introduced automated build and continuous integration environments using Maven and Continuum",
				"Helped establishing testing processes and procedures for QA team including setting up automated test environment, integrating it with build process, and trained testers on how to write automated functional tests using IBM Rational Functional Tester (RFT). ",
				"Fully designed a new framework for writing automated functional tests based on JUnit and Selenium that reduced the duration of QA test cycle from several days to several hours"
		}));
		jobs.add(createJob(resume, "Technical Lead (3 month contract)", "TDS Telecom", "Madison, WI", LocalDate.of(2007, 2, 1), LocalDate.of(2006, 5, 1), 
				new String[] {
				"Led a cross-functional team of eight software developers and system administrators. Planed the project timeline and resources.",
				"Managed the workload for individual team members, identified individual goals and objectives. Assessed project risks and identify the mitigation strategies. Maintained the communication between project stakeholders. ",
				"Ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews. Prepared the implementation plans and schedules. Performed post project analysis."
		}));
		jobs.add(createJob(resume, "Senior Programmer/Analyst", "Great Lakes Educational Loan Services Inc.", "Madison, WI", LocalDate.of(2005, 8, 1), LocalDate.of(2007, 2, 1), 
				new String[] {
				"Led a cross-functional team of five software developers and analysts. Established the common vision and directions for the team. Planed the project timeline and resources. Managed the workload for individual team members, identified individual goals and objectives. Assessed project risks and identify the mitigation strategies. Maintained the communication between project stakeholders. Ensured the quality of the delivered product through establishing the development guidelines and conducting regular code reviews. Prepared the implementation plans and schedules. Performed post project analysis.",
				"As a member of enterprise architecture committee participated in identifying the strategic direction for the IS department. Helped creating the company wide standards and development guidelines. Performed analyses on various subjects and presented the results for senior management.",
				"Planed, organize, and lead a range of trainings and seminars on different aspects of software development process. Mentored and provide guidelines and directions for junior team members. Led code review sessions and system design discussions. Organized and facilitated regular team meetings dedicated to the technical issues and resolutions."
		}));
		jobs.add(createJob(resume, "IT Consultant", "Isthmus Group Inc.", "Madison, WI", LocalDate.of(2004, 12, 1), LocalDate.of(2005, 8, 1), 
				new String[] {
				"Led an integration project for IBM Web Sphere Portal and Liferay portal server with custom content management module. Developed custom portlets, themes, and skins",
				"Provided expertise for both management and clients on various aspects of content management system development",
				"Planned, organized, and led training sessions for company management and co-workers"
		}));
		jobs.add(createJob(resume, "Programmer Analyst ", "US Cellular.", "Madison, WI", LocalDate.of(2002, 2, 1), LocalDate.of(2004, 12, 1), 
				new String[] {
				"Fully designed and developed multiple intranet based web sites from the ground up",
				"Implemented the first .NET based intranet web site in the company",
				"Advised management on various web development areas",
				"Worked with the cross-functional team of developers, testers, and designers located in Madison and Chicago"
		}));
		jobs.add(createJob(resume, "Web Developer", "Aesention", "Madison, WI", LocalDate.of(2000, 11, 1), LocalDate.of(2002, 2, 1), 
				new String[] {
				"Led successful implementation of multiple e-commerce web applications using various server-side scripting languages and RDBMS.",
				"Fully designed and developed number of web applications from the ground up",
				"Mentored web designers on various server-side technologies."
		}));
		jobs.add(createJob(resume, "Project Manager", "Promstroy Construction Ltd", "Nizhny Novgorod, Russia", LocalDate.of(1996, 6, 1), LocalDate.of(2000, 8, 1), 
				new String[] {
				"Led and organized work processes on multiple construction sites. Managed the communication process and served as a single point of contact for the customers and subcontractors",
				"Organized and coordinated work of multiple organizations involved in the construction process",
				"Produced technical and financial documentation in accordance with the local laws and government regulations"
		}));
		
		return jobs;
	}
	
	
	protected Job createJob(Resume resume, String title, String companyName, String location, LocalDate start, LocalDate end, String[] responsibilities) {
		final Job job = jobDao.saveAndFlush(new Job(resume, title, companyName, location, start, end));
		for(String r : responsibilities) {
			jobResponsibilityDao.saveOrCreateNew(new JobResponsibility(r, job));
		}
		LOG.info("Created {}", job);
		return job;
	}	
}
