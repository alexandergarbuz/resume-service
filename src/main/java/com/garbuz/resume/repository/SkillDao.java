package com.garbuz.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbuz.resume.entity.Skill;
import com.garbuz.resume.entity.SkillGroup;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface SkillDao extends JpaRepository<Skill, Long> {

	List<Skill> findBySkillGroup(SkillGroup skillGroup);
}
