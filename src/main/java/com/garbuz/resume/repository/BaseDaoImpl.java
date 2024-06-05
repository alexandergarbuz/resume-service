package com.garbuz.resume.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.garbuz.resume.entity.BaseEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	private Class<T> persistentClass;

	abstract SingularAttribute<T, Long> getIdAttribute();
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	
    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

	@Override
	public List<T> findAll() {
		LOG.debug("Loading all {} objects", this.persistentClass.getSimpleName());
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
		Root<T> root = criteria.from(persistentClass);
		criteria.select(root);

		List<T> entities = getEntityManager().createQuery(criteria).getResultList();
		LOG.debug("Found a list of {} {} objects", CollectionUtils.size(entities), this.persistentClass.getSimpleName());
		return entities;
	}

	@Override
	public T findById(Long id) {
		LOG.debug("Loading {} by id {}", this.persistentClass.getSimpleName(), id);
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
		Root<T> root = criteria.from(persistentClass);
		criteria.select(root);
		criteria.where(builder.equal(root.get(getIdAttribute()), id));

		T entity = getEntityManager().createQuery(criteria).getSingleResult();
		LOG.debug("Loaded {}", entity);
		return entity;
	}
	@Override
	public List<T> findByAttribute(SingularAttribute<T, String> attribute, String value) {
		LOG.debug("Loading list of {} objects by {}='{}'", this.persistentClass.getSimpleName(), attribute.getName(), value);
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
		Root<T> root = criteria.from(persistentClass);
		Order orderBy = builder.asc(root.get(getIdAttribute()));
		criteria.select(root);
		criteria.where(builder.equal(root.get(attribute), value));
		criteria.orderBy(orderBy);

		List<T> entities = getEntityManager().createQuery(criteria).getResultList();
		LOG.debug("Found a list of {} {} objects by {}='{}'", CollectionUtils.size(entities), this.persistentClass.getSimpleName(), attribute.getName(), value);
		return entities;
	}
	
	@Override
	@Transactional
	public T saveOrCreateNew(T objectToSave) {
		LOG.debug("Saving {}", objectToSave);
		T t = getEntityManager().merge(objectToSave);
		LOG.debug("Saved {}", t);
		return t;
	}
	@Override
	@Transactional
	public void remove(T objectToRemove) {
		LOG.debug("Removing {}", objectToRemove);
		getEntityManager().remove(getEntityManager().contains(objectToRemove)? objectToRemove : getEntityManager().merge(objectToRemove));
	}
	
}
