package com.garbuz.resume.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Resume")
public class Resume {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToOne(mappedBy = "resume",  fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private ContactInformation contactInformation;
	
	@OneToOne(mappedBy = "resume", fetch = FetchType.LAZY)
	private Summary summary;
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<Education> educations;
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<Certification> certifications;
//	private List<Position> positions;
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<SkillGroup> skills;
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<Recommendation> recommendations = new ArrayList<>();
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<Reference> references = new ArrayList<>();
	
	
	public Resume() {
	}	
	public Resume(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
		
	public ContactInformation getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}
	public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	
	public List<SkillGroup> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillGroup> skills) {
		this.skills = skills;
	}
	public List<Recommendation> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}
	
	public List<Reference> getReferences() {
		return references;
	}
	public void setReferences(List<Reference> references) {
		this.references = references;
	}
	
	public List<Education> getEducations() {
		return educations;
	}
	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	
	public List<Certification> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resume other = (Resume) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}
	@Override
	public String toString() {
		return "Resume [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}	
}
