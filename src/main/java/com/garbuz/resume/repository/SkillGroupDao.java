package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.entity.SkillGroup_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillGroupDao extends BaseDaoImpl<SkillGroup> {

	@Override
	SingularAttribute<SkillGroup, Long> getIdAttribute() {
		return SkillGroup_.id;
	}

}
