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
import org.springframework.web.bind.annotation.RestController;

import com.dharbortest.dao.CourseRepo;
import com.dharbortest.model.Course;

@RestController
@RequestMapping("/Class")
public class CourseController {

	@Autowired
	private CourseRepo repo;
	
	
	@GetMapping
	public List<Course> list(){
		return repo.findAll();
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
	
	@DeleteMapping(value="/code")
	public void eliminar(@PathVariable("code") String code)
	{
		repo.deleteById(code);
	}
}
