package com.garbuz.resume.entity;

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
@Table(name="Reference")
public class Reference {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="title")
	private String title;
	public Reference() {
	}
	public Reference(Resume resume, String name, String email, String phone, String title) {
		this.resume = resume;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.title = title;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, phone, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reference other = (Reference) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Reference [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", title=" + title
				+ "]";
	}
	
}
