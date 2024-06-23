package com.garbuz.resume.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
/**
When you have JPA / Hibernate Entities with @Entity annotation, and when you fetch data from the database using a repository or using getMethod() from the parent entity for the field which is being lazy-loaded from the parent entity, hibernate returns an object which will have all the fields/properties of the class which are mapped to DB table. On top of these fields, this object will also have two extra fields which are hibernateLazyInitializer and handler that is used to lazily load an entity.
If you have any use case of serializing this entity in JSON String format using Jackson library directly or indirectly (Maybe if you're returning entity as it to any REST API response or if you're storing entity to JSON data store like Elasticsearch), the JPA entity will be serialized with all the fields and hibernateLazyInitializer and handler as extra fields. So, if you do not ignore these fields, they will be serialized in JSON format which you can see if you read the JSON string.
So, to avoid this unnecessary serialization, you have to write this piece of code on JPA / Hibernate entity which will tell Jackson library that "Serialized JSON should not have fields hibernateLazyInitializer and handler. If you find them in object, just ignore them":

https://stackoverflow.com/questions/67353793/what-does-jsonignorepropertieshibernatelazyinitializer-handler-do
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resume {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToOne(mappedBy = "resume",  fetch = FetchType.LAZY)
	private ContactInformation contactInformation;
	
	@OneToOne(mappedBy = "resume", fetch = FetchType.LAZY)
	private Summary summary;
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<Education> educations;
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<Certification> certifications;
	
	@OneToMany(mappedBy="resume",  fetch = FetchType.LAZY)
	private List<Job> jobs;
	
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
	
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
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
