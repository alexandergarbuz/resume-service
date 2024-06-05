package com.garbuz.resume.repository;

import java.util.List;

import com.garbuz.resume.entity.BaseEntity;

import jakarta.persistence.metamodel.SingularAttribute;

public interface BaseDao<T extends BaseEntity> {

	public List<T> findAll();
	
	public T findById(Long id);
	
	public List<T> findByAttribute(SingularAttribute<T, String> attribute, String value);
	
	public T saveOrCreateNew(T objectToSave);

	public void remove(T objectToRemove);

}