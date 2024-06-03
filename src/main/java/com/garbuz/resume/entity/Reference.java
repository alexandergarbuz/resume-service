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
	private String emaIL;
	@Column(name="phone")
	private String phone;
	@Column(name="title")
	private String title;
	public Reference() {
	}
	public Reference(Long id, Resume resume, String name, String emaIL, String phone, String title) {
		super();
		this.id = id;
		this.resume = resume;
		this.name = name;
		this.emaIL = emaIL;
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
	public String getEmaIL() {
		return emaIL;
	}
	public void setEmaIL(String emaIL) {
		this.emaIL = emaIL;
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
		return Objects.hash(emaIL, id, name, phone, title);
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
		return Objects.equals(emaIL, other.emaIL) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Reference [id=" + id + ", name=" + name + ", emaIL=" + emaIL + ", phone=" + phone + ", title=" + title
				+ "]";
	}
	
}
