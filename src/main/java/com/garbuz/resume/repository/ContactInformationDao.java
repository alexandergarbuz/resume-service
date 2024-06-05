package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.ContactInformation;
import com.garbuz.resume.entity.ContactInformation_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class ContactInformationDao extends BaseDaoImpl<ContactInformation> {

	@Override
	public SingularAttribute<ContactInformation, Long> getIdAttribute() {
		return ContactInformation_.id;
	}

}
