package com.garbuz.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Certification;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface CertificationDao extends JpaRepository<Certification, Long> {
}
