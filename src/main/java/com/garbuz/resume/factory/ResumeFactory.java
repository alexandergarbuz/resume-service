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
		Resume contactInformation = dao.saveAndFlush(new Resume("Alexander", "Garbuz"));
		LOG.info("Created {}", contactInformation);
		return contactInformation;
	}
	
	
}
