package com.garbuz.resume.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.ContactInformation;
import com.garbuz.resume.repository.ContactInformationDao;

@Component
public class ContactInformationFactory {

	private static final Logger LOG = LoggerFactory.getLogger(ContactInformationFactory.class);
	
	private ContactInformationDao dao;
	
	public ContactInformationFactory(final ContactInformationDao dao) {
		this.dao = dao;
	}
	
	public ContactInformation createDefaultContactInformations(final Resume resume) {
		ContactInformation contactInformation = dao.saveOrCreateNew(new ContactInformation(resume, "alexander.garbuz@gmail.com","608-628-2448", "405 Burnt Sienna Dr.", "Middleton", "WI", "53562"));
		LOG.info("Created {}", contactInformation);
		return contactInformation;
	}
	
	
}
