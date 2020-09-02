package com.dharbortest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dharbortest.dao.StudentRepo;
import com.dharbortest.model.Course;
import com.dharbortest.model.Student;

class LoadCoursesTest extends Codechallenge001ApplicationTests{
	private static final Logger log = LoggerFactory.getLogger(LoadCoursesTest.class);

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	StudentRepo repo;
	
	@SuppressWarnings("unchecked")
	@Test
	void test() {
		List<Course> course = entityManager.createQuery("from Course").getResultList();
		log.info("Courses " + course.size());
		
		Student student = (Student) entityManager.createQuery("from Student where firstname='Jose'").getSingleResult();
		log.info("Student " + student.getCode());
		
		List<Student> students = entityManager.createQuery("SELECT s FROM Student s join s.courses sc where sc.code = 'C001' ").getResultList();
		log.info("Students " + students);
		
		List<Student> students001 = repo.findByCourseCode("C001");
		log.info("Students " + students001);
		
		List<Course> courses = entityManager.createQuery("SELECT c FROM Course c join c.students sc where sc.id = 43 ").getResultList();
		log.info("Courses " + courses);
		
		assertNotEquals(course, null);
		assertNotEquals(student, null);
		assertNotEquals(students, null);
		assertNotEquals(students001, null);
		assertNotEquals(courses, null);

	}

}
