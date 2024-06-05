package com.garbuz.resume.entity;

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
import jakarta.persistence.Table;

@Entity
@Table(name="Recommendation")
public class Recommendation extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	@JsonIgnoreProperties("recommendations")
	private Resume resume;
	@Column(name="author")
	private String author;
	@Column(name="author_title")
	private String authorTitle;
	@Column(name="relationship")
	private String relationship;
	@Column(name="text", length = 1000)
	private String text;	
	
	
	public Recommendation() {
	}

	public Recommendation(Resume resume, String author, String authorTitle, String relationship, String text) {
		this.resume = resume;
		this.author = author;
		this.authorTitle = authorTitle;
		this.relationship = relationship;
		this.text = text;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorTitle() {
		return authorTitle;
	}
	public void setAuthorTitle(String authorTitle) {
		this.authorTitle = authorTitle;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, authorTitle, id, relationship, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recommendation other = (Recommendation) obj;
		return Objects.equals(author, other.author) && Objects.equals(authorTitle, other.authorTitle)
				&& Objects.equals(id, other.id) && Objects.equals(relationship, other.relationship)
				&& Objects.equals(text, other.text);
	}

	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", author=" + author + ", authorTitle=" + authorTitle + ", relationship="
				+ relationship + ", text=" + text + "]";
	}

	
}
