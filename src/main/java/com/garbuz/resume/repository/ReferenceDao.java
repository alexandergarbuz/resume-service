package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ReferenceDao extends JpaRepository<Reference, Long> {
	
	List<Reference> findByResume(Resume resume);

}
