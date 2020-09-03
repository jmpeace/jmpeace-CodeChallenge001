package com.dharbortest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dharbortest.dao.CourseRepo;
import com.dharbortest.model.Course;
import com.dharbortest.service.CourseServ;

@RestController
@RequestMapping("/Classes")
public class CourseController {

	@Autowired
	private CourseRepo repo;
	
	@Autowired
	private CourseServ serv;
	
	@GetMapping
	public List<Course> list(
			@RequestParam(name = "code",required = false) String code,
			@RequestParam(name = "title",required = false) String title,
			@RequestParam(name = "desc",required = false) String desc
			){
		
		return serv.searchOrFindAll(code,title,desc);
	}
	
	@GetMapping(value = "/{code}")
	public Course list(@PathVariable("code") String code){
		return repo.findByCode(code);
	}
	
	
	@GetMapping("/Student/{studentId}")
	public List<Course> listWhereCourse(@PathVariable Integer studentId)
	{
		return repo.findByStudentId(studentId);
	}
	
	/**
	 * Add student to class
	 * @param code
	 * @param studentId
	 */
	@PutMapping("/{code}/{studentId}")
	public void subscribeToCourse(@PathVariable("code") String code,@PathVariable Integer studentId)
	{
		serv.subscribeToCourse(code,studentId);
	}
	
	/**
	 * Remove student from class
	 * @param code
	 * @param studentId
	 */
	@DeleteMapping("/{code}/{studentId}")
	public void unSubscribeFromCourse(@PathVariable("code") String code,@PathVariable Integer studentId)
	{
		serv.unsubscribeFromCourse(code,studentId);
	}
	
	@PostMapping
	public void insert(@RequestBody Course course)
	{
		repo.save(course);
	}
	
	@PutMapping
	public void update(@RequestBody Course course)
	{
		repo.save(course);
	}
	
	@DeleteMapping(value="/{code}")
	public void eliminar(@PathVariable("code") String code)
	{
		repo.deleteById(code);
	}
}
