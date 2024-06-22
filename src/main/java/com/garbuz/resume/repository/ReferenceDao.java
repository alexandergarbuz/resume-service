package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Reference;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ReferenceDao extends JpaRepository<Reference, Long> {

	public List<Reference> findByResume_FirstNameAndResume_LastName(final String lastName, final String firstName);


}
