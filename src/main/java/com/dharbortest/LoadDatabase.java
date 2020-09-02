package com.dharbortest;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dharbortest.dao.CourseRepo;
import com.dharbortest.dao.StudentRepo;
import com.dharbortest.model.Course;
import com.dharbortest.model.Student;
import com.google.common.collect.Sets;

@Configuration
public class LoadDatabase {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	
	/**
	 * Default Users
	 * @param repository
	 * @return
	 */
	@Bean
	CommandLineRunner initDatabase(StudentRepo studentRepo,CourseRepo coursesRepo) {

		return args -> {
			
			Student student001 = studentRepo.findByCode("S001");
			if(student001==null)
			student001 = studentRepo.save(new Student("S001","Jose","Paz"));
			
			Student student002 = studentRepo.findByCode("S002");
			if(student002==null)
			student002 = studentRepo.save(new Student("S002","Juan","Perez"));
			
			Student student003 = studentRepo.findByCode("S003");
			if(student003==null)
			student003 =studentRepo.save(new Student("S003","Carlos","Gomez"));
		
			Course course001 = coursesRepo.findByCode("C001");
			if(course001==null)
			{
				course001=coursesRepo.save(new Course("C001","Math","Math Classes"));
				course001.setStudents(Sets.newHashSet(student001,student002));		
				coursesRepo.save(course001);
			}
			
			Course course002 = coursesRepo.findByCode("C002");
			if(course002==null)
{
				course002=new Course("C002","Language","Language Classes");
				course002.setStudents(Sets.newHashSet(student001));
				coursesRepo.save(course002);
			}
			
			
			Course course003 = coursesRepo.findByCode("C003");
			if(course003==null) {
				course003 = coursesRepo.save(new Course("C003","Spanish","Spanish Classes"));
				course003.setStudents(Sets.newHashSet(student001,student002,student003));
				coursesRepo.save(course003);
			}
			

		
			
		};
	}


}
