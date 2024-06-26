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
@JsonIgnoreProperties({"resume"})
public class Recommendation  {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	@Column(name="author")
	private String author;
	@Column(name="author_title")
	private String authorTitle;
	@Column(name="relationship")
	private String relationship;
	@Column(name="linked_in_url")
	private String linkedInUrl;
	@Column(name="avatar_url")
	private String avatarUrl;
	@Column(name="text", length = 1000)
	private String text;	
	
	
	public Recommendation() {
	}

	public Recommendation(Resume resume, String author, String authorTitle, String relationship, String text, String linkedInUrl, String avatarUrl) {
		this.resume = resume;
		this.author = author;
		this.authorTitle = authorTitle;
		this.relationship = relationship;
		this.text = text;
		this.linkedInUrl = linkedInUrl;
		this.avatarUrl = avatarUrl;
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
	
	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, authorTitle, avatarUrl, id, linkedInUrl, relationship, text);
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
				&& Objects.equals(avatarUrl, other.avatarUrl) && Objects.equals(id, other.id)
				&& Objects.equals(linkedInUrl, other.linkedInUrl) && Objects.equals(relationship, other.relationship)
				&& Objects.equals(text, other.text);
	}

	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", author=" + author + ", authorTitle=" + authorTitle + ", relationship="
				+ relationship + ", linkedInUrl=" + linkedInUrl + ", avatarUrl=" + avatarUrl + ", text=" + text + "]";
	}
}
