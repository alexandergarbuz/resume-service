package com.garbuz.resume.factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Certification;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.repository.CertificationDao;

@Component
public class CertificationFactory {

	private static final Logger LOG = LoggerFactory.getLogger(CertificationFactory.class);
	
	private CertificationDao dao;
	
	public CertificationFactory(final CertificationDao dao) {
		this.dao = dao;
	}
	
	public List<Certification> createDefaultCertifications(final Resume resume) {
		List<Certification> certifications = new ArrayList<>(); 
		certifications.add(dao.saveAndFlush(new Certification("Master Certificate in Project Management", "University of Wisconsin, Madison", LocalDate.of(2011, 1, 1), resume))); 

		LOG.info("Created {}", certifications);
		return certifications;
	}
	
	
}
