package com.dharbortest.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {

	@Id @GeneratedValue
	private int student_id;
	
	@Column(length = 50, unique=true)
	private String code;
	
	@Column(length = 255)
	private String firstname;
	
	@Column(length = 255)
	private String lastname;

	@ManyToMany(mappedBy="students")
	@JsonIgnore
    Set<Course> courses;
	
	public Student() {
	}

	public Student(String code, String firstname,String lastname) {
		super();
		this.code = code;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", code=" + code + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
}
