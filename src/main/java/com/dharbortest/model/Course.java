package com.dharbortest.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Course {
	
	@Id
	@Column(length = 50, unique=true)
	private String code;
	
	@Column(length = 255)
	private String title;
	
	@Column(length = 255)
	private String description;

	@ManyToMany
	@JoinTable(name = "student_courses")
	@JsonIgnoreProperties("courses")
    Set<Student> students;
	
	public Course() {
	}
	
	public Course(String code, String title, String description) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
}
