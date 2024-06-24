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
		skills.add(createGroup(resume, "Languages", "Java, PHP, SQL, HTML, XML, XSL, CSS, JavaScript, CFML, UML"));
		skills.add(createGroup(resume, "Technologies", "REST API, API Gateways, J2EE, JSP, Servlets, JPA, JDBC"));
		skills.add(createGroup(resume, "Databases", "Microsoft SQL, Oracle, DB2, MySQL"));
		skills.add(createGroup(resume, "OS", "Microsoft Windows, Linux"));
		skills.add(createGroup(resume, "Servers", "IIS, Apache, Tomcat, WildFly, IBM WebSphere Liberty"));
		skills.add(createGroup(resume, "Frameworks", "Spring, Spring Boot, Struts, Hibernate, JUnit, Apache Cactus, EasyMock, Mockito, Selenium, Arquillian, jQuery"));
		skills.add(createGroup(resume, "Tools", "Maven, Ant, Gradle, Jenkins, Docker, AWS, Subversion, GitHub, Eclipse, IntelliJ IDEA, Apache JMeter"));
		skills.add(createGroup(resume, "Methodologies", "Agile, Extreme programming, Scrum, Kanban"));
		
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
