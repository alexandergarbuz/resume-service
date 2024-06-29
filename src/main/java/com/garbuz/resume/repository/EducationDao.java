package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Education;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EducationDao extends JpaRepository<Education,Long> {
	
	List<Education> findByResume_LastNameAndResume_FirstName(final String lastName, final String firstName);
}
