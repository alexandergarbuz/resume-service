package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Certification;
import com.garbuz.resume.entity.Certification_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CertificationDao extends BaseDaoImpl<Certification> {

	@Override
	SingularAttribute<Certification, Long> getIdAttribute() {
		return Certification_.id;
	}

}
