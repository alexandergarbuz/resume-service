package com.garbuz.resume.repository;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.entity.SkillGroup_;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Resume_;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.entity.SkillGroup_;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillGroupDao extends BaseDaoImpl<SkillGroup> {
	
	private static final Logger LOG = LoggerFactory.getLogger(SkillGroupDao.class);

	@Override
	SingularAttribute<SkillGroup, Long> getIdAttribute() {
		return SkillGroup_.id;
	}
	
	public List<SkillGroup> findlSkillsByResume(final Long resumeId) {
		LOG.debug("Loading skills for resumeId={}", resumeId);
		
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<SkillGroup> criteria = builder.createQuery(SkillGroup.class);
		Root<SkillGroup> root = criteria.from(SkillGroup.class);
		Order orderBy = builder.asc(root.get(SkillGroup_.id));
		
		
		Join<SkillGroup, Resume> join = root.join(SkillGroup_.resume);
		
		Predicate where = builder.equal(join.get(Resume_.id), resumeId);
		
		criteria.select(root);
		criteria.where(where);
		criteria.orderBy(orderBy);
		
		List<SkillGroup> skills = em.createQuery(criteria).getResultList();
		LOG.debug("Loaded {} SkillGroups", CollectionUtils.size(skills));
		return skills;
	}

}
