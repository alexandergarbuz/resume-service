package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Job;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface JobDao extends JpaRepository<Job, Long> {

	public List<Job> findByResume_FirstNameAndResume_LastName(final String lastName, final String firstName);
	
	public List<Job> findlByResumeId(final Long resumeId);

}
