package com.dharbortest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dharbortest.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

	Student findByCode(String code);
	Student findByFirstname(String firstname);
	Student findByLastname(String lastname);
	void deleteByCode(String code);

}
