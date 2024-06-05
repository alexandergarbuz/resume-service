package com.garbuz.resume.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.garbuz.resume.entity.Certification;
import com.garbuz.resume.entity.ContactInformation;
import com.garbuz.resume.entity.Education;
import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Skill;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.entity.Summary;
import com.garbuz.resume.repository.CertificationDao;
import com.garbuz.resume.repository.ContactInformationDao;
import com.garbuz.resume.repository.EducationDao;
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

	public Resume initializeData() {
		Resume resume = saveOrCreateNew(new Resume("Alexander", "Garbuz"));
		summaryDao.saveOrCreateNew(new Summary(
				resume,
				"Looking for Java Back End developer position",
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
}
