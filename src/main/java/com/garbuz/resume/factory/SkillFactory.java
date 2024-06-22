package com.garbuz.resume.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Skill;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.repository.SkillDao;
import com.garbuz.resume.repository.SkillGroupDao;

@Component
public class SkillFactory {

	private static final Logger LOG = LoggerFactory.getLogger(SkillFactory.class);
	
	private SkillDao skillDao;
	private SkillGroupDao skillGroupDao;
	
	public SkillFactory(final SkillDao skillDao, final SkillGroupDao skillGroupDao) {
		this.skillDao = skillDao;
		this.skillGroupDao = skillGroupDao;
	}

	public List<SkillGroup> createDefaulsSkills(final Resume resume) {
		
		List<SkillGroup> skills = new ArrayList<>();
		skills.add(createGroup(resume, "Languages", "Java, C#, Visual Basic, Visual Basic .NET, PHP, HTML/DHTML, XML/XSL, SQL, CSS, JavaScript, VBScript, CFML, UML"));
		skills.add(createGroup(resume, "Technologies", "J2EE, JSP, Servlets, JavaBeans, JDBC, EJB, ASP, ASP.NET, CGI, ADO, ColdFusion"));
		skills.add(createGroup(resume, "Databases", "Microsoft SQL, Oracle, DB2, MySQL"));
		skills.add(createGroup(resume, "OS", "Microsoft Windows, Linux"));
		skills.add(createGroup(resume, "Servers", "IIS, Apache, Tomcat, JBoss WildFly, New Atlanta ServletExec, JRun, WebLogic"));
		skills.add(createGroup(resume, "Frameworks", "Struts, Spring, Spring Boot, Hibernate, iBATIS SQL Maps, iBATIS DAO, JUnit, Apache Cactus, EasyMock, Mockito, Selenium, Arquillian"));
		skills.add(createGroup(resume, "Tools", "IBM Rational Application Developer (RAD), IBM Web Sphere Application Developer Studio (WSAD), Eclipse, IntelliJ IDEA, NetBeans, iReports, VisualCaffe, Borland JBuilder, Ant, Maven, Cruise Control, Continuum, Jenkins, Docker, AWS, Subversion, Git"));
		
		return skills;
	}
	
	protected List<String> parseSkills(final String skillsString) {
		return Arrays.asList(StringUtils.split(skillsString, ","));
	}
	
	protected SkillGroup createGroup(final Resume resume, final String groupName, final String skills)  {
		return createSkillGroup(resume, groupName, parseSkills(skills));
		
	}
	protected SkillGroup createSkillGroup(final Resume resume, final String groupName, final List<String> skillsList)  {
		SkillGroup group = skillGroupDao.saveAndFlush(new SkillGroup(resume,groupName));
		LOG.info("Created {}", group);
		List<Skill> savedSkills = new ArrayList<>();
		skillsList.forEach(skillName-> {
			Skill skill = skillDao.saveAndFlush(new Skill(skillName, group));
			savedSkills.add(skill);
			LOG.info("Created {}", skill);
		});
		group.setSkills(savedSkills);

		return group;
	}
}
