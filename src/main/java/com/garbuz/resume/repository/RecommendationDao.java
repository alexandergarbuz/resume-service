package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Resume;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RecommendationDao extends JpaRepository<Recommendation, Long>{

	
	List<Recommendation> findByResume(final Resume resume);
}
