package com.garbuz.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Summary;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface SummaryDao extends JpaRepository<Summary, Long>{

	Summary findByResume(Resume resume);
	
}
