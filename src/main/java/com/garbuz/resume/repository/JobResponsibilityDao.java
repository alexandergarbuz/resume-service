package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.JobResponsibility;
import com.garbuz.resume.entity.JobResponsibility_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JobResponsibilityDao extends BaseDaoImpl<JobResponsibility> {

	@Override
	SingularAttribute<JobResponsibility, Long> getIdAttribute() {
		return JobResponsibility_.id;
	}

	
}
