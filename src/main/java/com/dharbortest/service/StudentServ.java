package com.dharbortest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dharbortest.dao.StudentRepo;
import com.dharbortest.model.Student;

@Service
public class StudentServ {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private StudentRepo repo;
	
	/**
	 * Search for students using code, firstname or lastname if specified
	 * otherwise return the full list of students
	 * @param code
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Student> searchOrFindAll(String code, String firstname, String lastname) {
		
		boolean hasCode = code!=null;
		boolean hasFirstname = firstname!=null;
		boolean hasLastname = lastname!=null;
		
		if(!hasCode&&!hasFirstname&&!hasLastname)
		{
			return repo.findAll();
		}else
		{
			Query query =entityManager.createQuery("select s from Student s where s.id=s.id "+
					(hasCode?" and lower(s.code) like concat('%',:code,'%') ":" ")+
					(hasFirstname?" and lower(s.firstname) like concat('%',:firstname,'%') ":" ")+
					(hasLastname?" and lower(s.lastname) like concat('%',:lastname,'%') ":" "));
			
			if(hasCode)
			query.setParameter("code", code.toLowerCase());
			
			if(hasFirstname)
			query.setParameter("firstname", firstname.toLowerCase());
			
			if(hasLastname)
			query.setParameter("lastname",lastname.toLowerCase());
			
			List<Student> students = query.getResultList();
			
			return students;
		}

	}

	
	

}
