package com.garbuz.resume.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Skill_Group")
public class SkillGroup extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy="skillGroup",  fetch = FetchType.LAZY)
	@JsonIgnoreProperties("skillGroup")
	private List<Skill> skills;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	public SkillGroup() {
	}
	public SkillGroup(Resume resume,String name) {
		this.name = name;
		this.resume = resume;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillGroup other = (SkillGroup) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "SkillGroup [id=" + id + ", name=" + name + "]";
	}
}
