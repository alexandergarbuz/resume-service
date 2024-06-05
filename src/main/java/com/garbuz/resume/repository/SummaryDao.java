package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Summary;
import com.garbuz.resume.entity.Summary_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SummaryDao extends BaseDaoImpl<Summary>{

	@Override
	public SingularAttribute<Summary, Long> getIdAttribute() {
		return Summary_.id;
	}

	
}
