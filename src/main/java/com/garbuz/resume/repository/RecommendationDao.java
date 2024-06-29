package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Recommendation;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RecommendationDao extends JpaRepository<Recommendation, Long>{
	
	public List<Recommendation> findByResume_LastNameAndResume_FirstName(final String lastName, final String firstName);
}
