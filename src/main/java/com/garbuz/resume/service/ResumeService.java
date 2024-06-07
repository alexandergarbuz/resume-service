package com.garbuz.resume.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.garbuz.resume.entity.Certification;
import com.garbuz.resume.entity.ContactInformation;
import com.garbuz.resume.entity.Education;
import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.JobResponsibility;
import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Skill;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.entity.Summary;
import com.garbuz.resume.repository.CertificationDao;
import com.garbuz.resume.repository.ContactInformationDao;
import com.garbuz.resume.repository.EducationDao;
import com.garbuz.resume.repository.JobDao;
import com.garbuz.resume.repository.JobResponsibilityDao;
import com.garbuz.resume.repository.RecommendationDao;
import com.garbuz.resume.repository.ReferenceDao;
import com.garbuz.resume.repository.ResumeDao;
import com.garbuz.resume.repository.SkillDao;
import com.garbuz.resume.repository.SkillGroupDao;
import com.garbuz.resume.repository.SummaryDao;

@Service
public class ResumeService {
	
	private final static Logger LOG = LoggerFactory.getLogger(ResumeService.class);
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private RecommendationDao recommendationDao;
	@Autowired
	private ReferenceDao referenceDao;
	@Autowired
	private ContactInformationDao contactInformationDao;
	@Autowired
	private SummaryDao summaryDao;
	@Autowired
	private EducationDao educationDao;
	@Autowired
	private CertificationDao certificationDao;
	@Autowired
	private SkillGroupDao skillGroupDao;
	@Autowired
	private SkillDao skillDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private JobResponsibilityDao jobResponsibilityDao;

	public Resume findResume(final Long id) {
		LOG.info("Loading resume for {}", id);
		Resume r = this.resumeDao.findCompleteResumeById(id);
		LOG.info("Loaded {} ", r);
		return r;
	}
	public Resume saveOrCreateNew(final Resume resumeToSave) {
		LOG.info("Saving {}", resumeToSave);
		final Resume savedResume = this.resumeDao.saveOrCreateNew(resumeToSave);
		LOG.info("Saved {} ", savedResume);
		return savedResume;
	}
	
	public List<Reference> findReferencesByFirstAndLastName(final String firstName, final String lastName) {
		LOG.debug("Loading info for {} {}", firstName, lastName);
		List<Reference> references = this.referenceDao.findReferencesByFirstAndLastName(firstName, lastName);
		LOG.info("Loaded {} references", CollectionUtils.size(references));
		return references;
	}
	public List<SkillGroup> findSkillsByResumeId(final Long resumeId) {
		LOG.debug("Loading skills for resumeId={}", resumeId);
		
		List<SkillGroup> skills = this.skillGroupDao.findlSkillsByResume(resumeId);
		
		LOG.debug("Loaded {} skills", CollectionUtils.size(skills));
		return skills;
	}

	public Resume initializeData() {
		Resume resume = saveOrCreateNew(new Resume("Alexander", "Garbuz"));
		summaryDao.saveOrCreateNew(new Summary(
				resume,
				"Looking for Java Back End developer job",
				"Senior IT professional with more than 25 years of combined software development, leadership and management experience in insurance, healthcare, telecommunications, and e-commerce industries"
				));
		contactInformationDao.saveOrCreateNew(new ContactInformation(resume, "alexander.garbuz@gmail.com","608-628-2448", "405 Burnt Sienna Dr.", "Middleton", "WI", "53562"));
		
		List<SkillGroup> skills = new ArrayList<>();
		skills.add(createSkillGroup(resume, "Languages", "Java, C#, Visual Basic, Visual Basic .NET, PHP, HTML/DHTML, XML/XSL, SQL, CSS, JavaScript, VBScript, CFML, UML"));
		skills.add(createSkillGroup(resume, "Technologies", "J2EE, JSP, Servlets, JavaBeans, JDBC, EJB, ASP, ASP.NET, CGI, ADO, ColdFusion"));
		skills.add(createSkillGroup(resume, "Databases", "Microsoft SQL, Oracle, DB2, MySQL"));
		skills.add(createSkillGroup(resume, "OS", "Microsoft Windows, Linux"));
		skills.add(createSkillGroup(resume, "Servers", "IIS, Apache, Tomcat, JBoss WildFly, New Atlanta ServletExec, JRun, WebLogic"));
		skills.add(createSkillGroup(resume, "Frameworks", "Struts, Spring, Spring Boot, Hibernate, iBATIS SQL Maps, iBATIS DAO, JUnit, Apache Cactus, EasyMock, Mockito, Selenium, Arquillian"));
		skills.add(createSkillGroup(resume, "Tools", "IBM Rational Application Developer (RAD), IBM Web Sphere Application Developer Studio (WSAD), Eclipse, IntelliJ IDEA, NetBeans, iReports, VisualCaffe, Borland JBuilder, Ant, Maven, Cruise Control, Continuum, Jenkins, Subversion, Git"));
		

		createJob(resume, "Sr. Java Developer / Consultant", "Ford Credit", "Remote", LocalDate.of(2021, 8, 1), LocalDate.of(2024, 4, 1),
			new String[] {
				"Developed and maintained a number of micro-services using Spring Boot and Oracle. Helped the team to migrate from ADFS (Active Directory Federation Service) to Azure AD; Participated in building POC for deploying services to GCP (Google Could Platform) utilizing Google Apigee platform as abstraction layer to provide access to backend service. Used S3 SDK to access and store objects in AWS storage;",
				"Led successful adaptation of Agile development practices such as test driven development, pair programming, iterative development, and continuous integration. Used GitHub, Jenkins, and Gradle to implement continuous integration/continues deployment environment. Utilized Checkmarx and FOSSA to ensure code quality and security compliance. Developed a suite of automated functional/acceptance tests using Postman. Built performance/load tests using Apache JMeter. Ensured targeted test coverage using JaCoCo code coverage reports;",
				"Maintained legacy Java web application utilizing Servlets, Velocity templates, jQuery, DB2 and IBM WebSphere Liberty server;",
				"Actively participated in project planning and management, created estimates, and provided status reports to management. Planned, organized and led meetings and training sessions. Mentored less experienced developers, conducted design and code reviews, performed analysis for senior management;", 
				"Provided on-call support;"
				});
		createJob(resume, "Sr. Java Developer", "CDW", "Madison, WI", LocalDate.of(2015, 9, 1), LocalDate.of(2021, 6, 1),
			new String[] {
				"Worked on a number of projects delivering both new functionality as well as providing maintenance and support for the existing applications;",
				"Helped define technical requirements and estimated assigned tasks. Used JPA and Hibernate to store and retrieve information from MS SQL Server databases. Used Prime Faces JSF implementation to build responsive UI layer for web based applications.",
				"Developed a number of RESTful web services to share information between multiple applications and platforms (web and mobile);",
				"Utilized Agile development practices such as test driven development, iterative development, continuous integration. Designed and developed functional testing framework using Arquillian and Selenium. Used Maven and Jenkins to set up continuous integration environment builds. Ensured targeted test coverage using JaCoCo code coverage reports integrated into Maven builds;",
				"Worked closely with the product owners and customers and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, estimating, as well as developing and testing of the delivered functionality;",
				"Participated in the hiring process, perform initial technical screening on the phone and conduct in-person interviews;",
				"Worked with contractors, conducted code reviews, mentored less experienced developers;",
				"Provided on-call support for the clients. Used DynaTrace to document and troubleshoot issues with the applications we supported."
				});		
		createJob(resume, "Technical Lead / Consultant", "American Family Insurance", "Madison, WI", LocalDate.of(2013, 2, 1), LocalDate.of(2015, 9, 1),
				new String[] {
				"Led technical implementation of a large development project. Worked closely with the project manager and participated in all phases of the project delivery starting with the project initiation, requirements gathering and analysis, work planning and scheduling, as well as monitoring and controlling of the project work;",
				"Reviewed technical requirements, provided estimates, facilitated issue resolution, coordinated work for developers, and ensured that software development best practices were followed. Conducted code reviews, mentored less experienced developers;",
				"Helped troubleshoot issues related to Guidewire PolicyCenter environment configuration and work with various teams to ensure prompt resolution;",
				"Coordinated work with outside vendors for security assessments and load and penetration testing."
				});	
		
		
		this.referenceDao.saveOrCreateNew(new Reference(resume, "Erick Hallick", "erick@hallick.com", "555-555-5555", "Executive VP of Operations @ CPM Healthgrades"));
		this.referenceDao.saveOrCreateNew(new Reference(resume, "Aditya Prakash", "Aditya@Prakash.com", "111-111-2222", "Project Manager @ American Family Insurance"));
		this.referenceDao.saveOrCreateNew(new Reference(resume, "Jeff Fletcher", "Jeff@Fletcher.com", "666-333-4444", "Sr. Database Developer @ CPM Healthgrades"));
		
		this.educationDao.saveOrCreateNew(new Education(
				"Cardinal Stritch University, Madison WI", 
				"Master of Business Administration", 
				LocalDate.of(2004, 12, 1),
				LocalDate.of(2006, 6, 1),
				"",
				resume
				));
		this.educationDao.saveOrCreateNew(new Education(
				"Nizhny Novgorod State Architecture Academy, Nizhny Novgorod, Russia", 
				"Bachelor of Science in Civil Engineering and Managemen", 
				LocalDate.of(1991, 9, 1),
				LocalDate.of(1996, 7, 1),
				"Graduated with honors (GPA 4.0)",
				resume
				));
		
		this.certificationDao.saveOrCreateNew(new Certification("Master Certificate in Project Management", "University of Wisconsin, Madison", LocalDate.of(2011, 1, 1), resume));
		

		this.recommendationDao.saveOrCreateNew(new Recommendation(
			resume,
			"Erick Hallick",
			"Executive VP of Operations @ CPM Healthgrades",
			"Managed Alexander directly",
			"One of the most desirable characteristics in an employee is someone who takes complete ownership of the problem they are working on. It is very rare to find, but Alex had this in spades. I don't think a week went by without Alex knocking on my door with a new idea on how to improve the work we were doing and our company. Alex was asked to implement most of his ideas immediately and he made significant improvements to the processes and project management around our CRM database build projects. Communication and transparency with clients improved dramatically and I received several compliments regarding the improvements. When I declined to implement one of Alex's ideas he accepted my decision without issue. He was a joy to work with. I would hire Alex again without reservation"
		));
		this.recommendationDao.saveOrCreateNew(new Recommendation(
			resume,
			"Aditya Prakash",
			"Project Manager @ American Family Insurance",
			"Worked with Alexander on the same team",
			"Alex is focused and has a strategic approach to project management, which resulted in success deliverables assigned as part of the App migration program. Alex had shown responsiveness for the projects that he is responsible from end to end. During the App migration, program implementation I had pleasure to collaborate around agile principles, scrum framework including best project practices to ensure success of each other deliverables. He had shown great technical acumen that the project team members ran brainstorming ideas with him around challenges and blockers. Alex showed great people skills on how to motivate people or dial back when great necessary to make sure that project is completed on time. Alex would be great asset to any team."
		));
		this.recommendationDao.saveOrCreateNew(new Recommendation(
			resume,
			"Jeff Fletcher",
			"Sr. Database Developer @ CPM Healthgrades",
			"Reported directly to Alexander",
			"Alex is one of the best managers I have had the pleasure to work for. He truly believes it is his responsibility to look out for his team and to remove obstacles so that they may succeed, as well as ensure that objectives are accomplished. When I started with CPM there was an environmental issue that was affecting my performance, and while Alex could not eliminate the issue he did come up with ways to mitigate it and he followed up to see if there was an improvement. Alex lead the expansion of the development team, doubling its size; and he also created a project management team. Through all of this, Alex kept a sense of humor and helped everyone on the teams manage heavy workloads and tight deadlines. I've enjoyed working for Alex and look forward to more opportunities to do so."
		));
		

		
		resume = findResume(resume.getId());
		return resume;
	}
	
	protected SkillGroup createSkillGroup(final Resume resume, final String groupName, final String skills)  {
		return createSkillGroup(resume, groupName, Arrays.asList(StringUtils.split(skills, ", ")));
		
	}
	protected SkillGroup createSkillGroup(final Resume resume, final String groupName, final List<String> skills)  {
		SkillGroup group = skillGroupDao.saveOrCreateNew(new SkillGroup(resume,groupName));
		List<Skill> savedSkills = new ArrayList<>();
		for(String skillName : skills) {
			savedSkills.add(skillDao.saveOrCreateNew(new Skill(skillName, group)));
		}
		group.setSkills(savedSkills);
		return group;
	}
	
	protected Job createJob(Resume resume, String title, String companyName, String location, LocalDate start, LocalDate end, String[] responsibilities) {
		Job job = jobDao.saveOrCreateNew(new Job(resume, title, companyName, location, start, end));
		for(String r : responsibilities) {
			JobResponsibility jr = jobResponsibilityDao.saveOrCreateNew(new JobResponsibility(r, job));
		}
		return job;
	}
	
}
