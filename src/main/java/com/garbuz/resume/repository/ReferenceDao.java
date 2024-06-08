package com.garbuz.resume.repository;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.Job_;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Reference_;
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
public class ReferenceDao extends BaseDaoImpl<Reference> {

	private static final Logger LOG = LoggerFactory.getLogger(ReferenceDao.class);
	
	@Override
	SingularAttribute<Reference, Long> getIdAttribute() {
		return Reference_.id;
	}
	
	public List<Reference> findReferencesByLastAndFirstName(final String lastName, final String firstName) {
		LOG.debug("Loading references for {} {}", lastName, firstName);
		
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Reference> criteria = builder.createQuery(Reference.class);
		Root<Reference> root = criteria.from(Reference.class);
		Order orderBy = builder.asc(root.get(Reference_.id));
		
		
		Join<Reference, Resume> join = root.join(Reference_.resume);
		
		Predicate whereFirstName = builder.equal(join.get(Resume_.firstName), firstName);
		Predicate whereLastName = builder.equal(join.get(Resume_.lastName), lastName);
		Predicate[] where = new Predicate[] {whereFirstName, whereLastName};
		
		criteria.select(root);
		criteria.where(where);
		criteria.orderBy(orderBy);
		
		List<Reference> references = em.createQuery(criteria).getResultList();
		LOG.debug("Loaded {} references", CollectionUtils.size(references));
		return references;
	}
	
	public List<Job> findJobsByLastAndFirstName(final String lastName, final String firstName) {
		LOG.debug("Loading jobs for {} {}", lastName, firstName);
		
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Job> criteria = builder.createQuery(Job.class);
		Root<Job> root = criteria.from(Job.class);
		Order orderBy = builder.asc(root.get(Job_.id));
		
		
		Join<Job, Resume> join = root.join(Job_.resume);
		
		Predicate whereFirstName = builder.equal(join.get(Resume_.firstName), firstName);
		Predicate whereLastName = builder.equal(join.get(Resume_.lastName), lastName);
		Predicate[] where = new Predicate[] {whereFirstName, whereLastName};
		
		criteria.select(root);
		criteria.where(where);
		criteria.orderBy(orderBy);
		
		List<Job> jobs = em.createQuery(criteria).getResultList();
		LOG.debug("Loaded {} jobs", CollectionUtils.size(jobs));
		return jobs;
	}

}
