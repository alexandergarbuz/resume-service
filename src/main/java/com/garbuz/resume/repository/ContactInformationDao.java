package com.garbuz.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garbuz.resume.entity.ContactInformation;
import com.garbuz.resume.entity.Resume;

public interface ContactInformationDao extends JpaRepository<ContactInformation, Long> {
	ContactInformation findByResume(final Resume resume);
}
