package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Reference_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ReferenceDao extends BaseDaoImpl<Reference> {

	@Override
	SingularAttribute<Reference, Long> getIdAttribute() {
		return Reference_.id;
	}
	

}
