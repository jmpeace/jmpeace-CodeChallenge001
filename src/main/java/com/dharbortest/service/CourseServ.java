package com.dharbortest.service;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dharbortest.dao.CourseRepo;
import com.dharbortest.dao.StudentRepo;
import com.dharbortest.model.Course;
import com.dharbortest.model.Student;

@Service
public class CourseServ {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private CourseRepo repo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	/**
	 * Search for students using code, firstname or lastname if specified
	 * otherwise return the full list of students
	 * @param code
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> searchOrFindAll(String code, String title, String desc) {
		
		boolean hasCode = code!=null;
		boolean hasTitle = title!=null;
		boolean hasDesc = desc!=null;
		
		if(!hasCode&&!hasTitle&&!hasDesc)
		{
			return repo.findAll();
		}else
		{
			Query query =entityManager.createQuery("select c from Course c where c.code=c.code "+
					(hasCode?" and lower(c.code) like concat('%',:code,'%') ":" ")+
					(hasTitle?" and lower(c.title) like concat('%',:title,'%') ":" ")+
					(hasDesc?" and lower(c.description) like concat('%',:desc,'%') ":" "));
			
			if(hasCode)
			query.setParameter("code", code.toLowerCase());
			
			if(hasTitle)
			query.setParameter("title", title.toLowerCase());
			
			if(hasDesc)
			query.setParameter("desc",desc.toLowerCase());
			
			List<Course> courses = query.getResultList();
			
			return courses;
		}

	}

	public void subscribeToCourse(String code, Integer studentId) {
		
		Course course = repo.findByCode(code);
		Student student = studentRepo.findById(studentId).get();
		course.getStudents().add(student);
		repo.save(course);
	}
	
	
	public void unsubscribeFromCourse(String code, Integer studentId) {
		
		Course course = repo.findByCode(code);
		Student student = studentRepo.findById(studentId).get();
		course.getStudents().remove(student);
		repo.save(course);
	}
	
	

}
