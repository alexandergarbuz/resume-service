package com.garbuz.resume.repository;

import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Recommendation_;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RecommendationDao extends BaseDaoImpl<Recommendation>{

	@Override
	SingularAttribute<Recommendation, Long> getIdAttribute() {
		return Recommendation_.id;
	}
}
