package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Skill;
import com.garbuz.resume.entity.Skill_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillDao extends BaseDaoImpl<Skill> {

	@Override
	SingularAttribute<Skill, Long> getIdAttribute() {
		return Skill_.id;
	}

	
}
