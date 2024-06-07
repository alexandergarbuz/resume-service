package com.garbuz.resume.entity;

import java.time.LocalDate;
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
@Table(name = "Job")
@JsonIgnoreProperties({"resume"})
public class Job extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id")
	private Resume resume;
	
	@Column(name="title")
	private String title;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="location")
	private String location;
	
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	private List<JobResponsibility> responsibilities;
	
	@Column(name="start_date")
	private LocalDate start;
	
	@Column(name="end_date")
	private LocalDate end;
	
	public Job() {
	}
	
	public Job(Resume resume, String title, String companyName, String location, LocalDate start, LocalDate end) {
		super();
		this.resume = resume;
		this.title = title;
		this.companyName = companyName;
		this.location = location;
		this.start = start;
		this.end = end;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<JobResponsibility> getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(List<JobResponsibility> responsibilities) {
		this.responsibilities = responsibilities;
	}
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	@Override
	public int hashCode() {
		return Objects.hash(companyName, end, id, location, resume, start, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(companyName, other.companyName) && Objects.equals(end, other.end)
				&& Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(resume, other.resume) && Objects.equals(start, other.start)
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", resume=" + resume + ", title=" + title + ", companyName=" + companyName
				+ ", location=" + location + ", start=" + start + ", end=" + end + "]";
	}
}
