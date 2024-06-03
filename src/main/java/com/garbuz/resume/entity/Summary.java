package com.garbuz.resume.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Summary")
public class Summary {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	@Column(name="objective", length = 500)
	private String objective;
	@Column(name="summary", length = 1000)
	private String summary;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	public Summary() {
	}
	public Summary(Long id, String objective, String summary) {
		super();
		this.id = id;
		this.objective = objective;
		this.summary = summary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, objective, summary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Summary other = (Summary) obj;
		return Objects.equals(id, other.id) && Objects.equals(objective, other.objective) && Objects.equals(summary, other.summary);
	}
	@Override
	public String toString() {
		return "Summary [id=" + id + ", objective=" + objective + ", summary=" + summary + "]";
	}
	
	
}
