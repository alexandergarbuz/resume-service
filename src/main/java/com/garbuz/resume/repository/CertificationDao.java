package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Certification;
import com.garbuz.resume.entity.Resume;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface CertificationDao extends JpaRepository<Certification, Long> {

	List<Certification> findByResume(Resume resume);
}
