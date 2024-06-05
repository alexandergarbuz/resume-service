package com.garbuz.resume.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Education")
public class Education extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String name;
	private String degree;
	private LocalDate startDate;
	private LocalDate endDate;
	private String comments;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	public Education() {
	}
	public Education(Long id, String name, String degree, LocalDate startDate, LocalDate endDate, String comments, Resume resume) {
		this.id = id;
		this.name = name;
		this.degree = degree;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
		this.resume = resume;
	}
	public Education(String name, String degree, LocalDate startDate, LocalDate endDate, String comments, Resume resume) {
		this.name = name;
		this.degree = degree;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
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
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		return Objects.hash(comments, degree, endDate, id, name, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Education other = (Education) obj;
		return Objects.equals(comments, other.comments) && Objects.equals(degree, other.degree)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(startDate, other.startDate);
	}
	@Override
	public String toString() {
		return "Education [id=" + id + ", name=" + name + ", degree=" + degree + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", comments=" + comments + "]";
	}

	
}
