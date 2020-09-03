package com.dharbortest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dharbortest.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

	public Student findByCode(String code);
	public List<Student> findByCodeContaining(String code);
	public List<Student> findByFirstnameContaining(String firstname);
	public List<Student> findByLastnameContaining(String lastname);
	public Integer deleteByCode(String code);
	
	@Query("SELECT s FROM Student s join s.courses sc where sc.code = :code")
    public List<Student> findByCourseCode(@Param("code") String code);
	
}
