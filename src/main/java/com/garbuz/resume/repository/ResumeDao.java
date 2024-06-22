package com.garbuz.resume.repository;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Resume_;
import com.garbuz.resume.entity.SkillGroup_;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ResumeDao extends BaseDaoImpl<Resume> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ResumeDao.class);

	@Override
	public SingularAttribute<Resume, Long> getIdAttribute() {
		return Resume_.id;
	}
	
	public Resume findCompleteResumeById(Long id) {
		LOG.debug("Loading Resume by id={}", id);
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Resume> criteria = builder.createQuery(Resume.class);
		Root<Resume> root = criteria.from(Resume.class);
		Order orderBy = builder.asc(root.get(Resume_.id));
		
		root.join(Resume_.summary);
		root.join(Resume_.contactInformation);
		root.join(Resume_.skills).join(SkillGroup_.skills);
		root.join(Resume_.recommendations);
		root.join(Resume_.references);
		root.join(Resume_.certifications);
		
		criteria.select(root);
		criteria.where(builder.equal(root.get(Resume_.id), id));
		criteria.orderBy(orderBy);

		List<Resume> resumes = em.createQuery(criteria).getResultList();
		Resume resume = CollectionUtils.size(resumes) > 0 ? resumes.get(0) : null;
		LOG.debug("Loaded {}", resume);
		return resume;
	}

    public long getCountOfResumes() {
    	LOG.debug("Counting number of resumes");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Resume> root = criteriaQuery.from(Resume.class);
        criteriaQuery.select(criteriaBuilder.count(root));
        long count = getEntityManager().createQuery(criteriaQuery).getSingleResult();
        LOG.debug("Found {}", count);
        return count;
    }
    
    public Resume getResumeWithLowestId() {
    	LOG.debug("Getting resume with lowest id");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Resume> criteriaQuery = criteriaBuilder.createQuery(Resume.class);
        Root<Resume> root = criteriaQuery.from(Resume.class);

        criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get(Resume_.id)));

        Resume r = getEntityManager().createQuery(criteriaQuery)
                            .setMaxResults(1)
                            .getSingleResult();
        LOG.debug("Found {} ", r);
        return r;
    }
}
