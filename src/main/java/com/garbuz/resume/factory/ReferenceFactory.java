package com.garbuz.resume.factory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.repository.ReferenceDao;

@Component
public class ReferenceFactory {

	private static final Logger LOG = LoggerFactory.getLogger(ReferenceFactory.class);
	
	private ReferenceDao dao;
	
	public ReferenceFactory(final ReferenceDao dao) {
		this.dao = dao;
	}
	
	public List<Reference> createDefaultReferences(final Resume resume) {
		final List<Reference> references = new ArrayList<>();
		references.add(new Reference(resume, "Erick Hallick", "erick@hallick.com", "555-555-5555", "Executive VP of Operations @ CPM Healthgrades"));
		references.add(new Reference(resume, "Aditya Prakash", "Aditya@Prakash.com", "555-555-5555", "Project Manager @ American Family Insurance"));
		references.add(new Reference(resume, "Jeff Fletcher", "Jeff@Fletcher.com", "555-555-5555", "Sr. Database Developer @ CPM Healthgrades"));
		references.forEach(reference -> {
			Reference ref = dao.saveOrCreateNew(reference);
			LOG.info("Saved {}", ref);
		});
		return references;
	}
	
	
}
