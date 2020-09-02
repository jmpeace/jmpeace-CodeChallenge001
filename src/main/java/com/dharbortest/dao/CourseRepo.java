package com.dharbortest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dharbortest.model.Course;

public interface CourseRepo extends JpaRepository<Course,String> {

	Course findByCode(String code);
	Course findByTitle(String title);
	Course findByDescription(String description);
}
