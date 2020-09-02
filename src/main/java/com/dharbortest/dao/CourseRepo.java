package com.dharbortest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dharbortest.model.Course;

public interface CourseRepo extends JpaRepository<Course,String> {

	Course findByCode(String code);
	Course findByTitleContaining(String title);
	Course findByDescriptionContaining(String description);
	
	@Query("SELECT c FROM Course c join c.students sc where sc.id = :id")
    public List<Course> findByStudentId(@Param("id") Integer id);
}
