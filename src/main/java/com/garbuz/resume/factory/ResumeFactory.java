package com.garbuz.resume.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.repository.ResumeDao;

@Component
public class ResumeFactory {

	private static final Logger LOG = LoggerFactory.getLogger(ResumeFactory.class);
	
	private ResumeDao dao;
	
	public ResumeFactory(final ResumeDao dao) {
		this.dao = dao;
	}

	public Resume createDefaultResume() {
		Resume contactInformation = dao.saveAndFlush(new Resume(
				"Alexander", 
				"Garbuz",
				"Looking for leadership position in a technology driven organization where I can utilize my problem solving, mentoring and communication skills.",
				"Senior IT professional with more than 25 years of combined software development, leadership and management experience in insurance, healthcare, telecommunications, and e-commerce industries",
				"alexander.garbuz@gmail.com",
				"608-628-2448", 
				"405 Burnt Sienna Dr.", 
				"Middleton", 
				"WI", 
				"53562"));
		LOG.info("Created {}", contactInformation);
		return contactInformation;
	}
	public Resume createTemplateResume() {
		Resume contactInformation = dao.saveAndFlush(new Resume(
				"Alexander", 
				"Garbuz",
				"Template Resume.",
				"Senior IT professional with more than 25 years of combined software development, leadership and management experience in insurance, healthcare, telecommunications, and e-commerce industries",
				"alexander.garbuz@gmail.com",
				"608-628-2448", 
				"405 Burnt Sienna Dr.", 
				"Middleton", 
				"WI", 
				"53562"));
		LOG.info("Created {}", contactInformation);
		return contactInformation;
	}	
	
}
