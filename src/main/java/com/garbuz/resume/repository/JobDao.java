package com.garbuz.resume.repository;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.Job_;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Resume_;

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
public class JobDao extends BaseDaoImpl<Job> {
	
	private static final Logger LOG = LoggerFactory.getLogger(JobDao.class);

	@Override
	SingularAttribute<Job, Long> getIdAttribute() {
		return Job_.id;
	}
	
	public List<Job> findlJobsByResume(final Long resumeId) {
		LOG.debug("Loading jobs for resumeId={}", resumeId);
		
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Job> criteria = builder.createQuery(Job.class);
		Root<Job> root = criteria.from(Job.class);
		Order orderBy = builder.asc(root.get(Job_.id));
		
		
		Join<Job, Resume> join = root.join(Job_.resume);
		
		Predicate where = builder.equal(join.get(Resume_.id), resumeId);
		
		criteria.select(root);
		criteria.where(where);
		criteria.orderBy(orderBy);
		
		List<Job> skills = em.createQuery(criteria).getResultList();
		LOG.debug("Loaded {} Jobs", CollectionUtils.size(skills));
		return skills;
	}

}
