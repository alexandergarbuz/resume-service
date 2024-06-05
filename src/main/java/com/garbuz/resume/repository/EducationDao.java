package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Education;
import com.garbuz.resume.entity.Education_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EducationDao extends BaseDaoImpl<Education> {
	@Override
	SingularAttribute<Education, Long> getIdAttribute() {
		return Education_.id;
	}
}
