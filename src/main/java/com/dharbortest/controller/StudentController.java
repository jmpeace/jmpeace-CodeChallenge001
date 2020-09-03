package com.dharbortest.controller;

import java.util.List;
import java.util.Optional;

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

import com.dharbortest.dao.StudentRepo;
import com.dharbortest.model.Student;
import com.dharbortest.service.StudentServ;

@RestController
@RequestMapping("Students")
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private StudentServ serv;
	
	
	@GetMapping
	public List<Student> list(
			@RequestParam(name = "code",required = false) String code,
			@RequestParam(name = "firstname",required = false) String firstname,
			@RequestParam(name = "lastname",required = false) String lastname
			){
		
		return serv.searchOrFindAll(code,firstname,lastname);
		
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Student> list(@PathVariable("id") Integer id){
		return repo.findById(id);
	}
	
	@GetMapping("/Class/{courseCode}")
	public List<Student> listWhereCourse(@PathVariable String courseCode)
	{
		return repo.findByCourseCode(courseCode);
	}
	
	@PostMapping
	public void insert(@RequestBody Student student)
	{
		repo.save(student);
	}
	
	@PutMapping
	public void update(@RequestBody Student student)
	{
		repo.save(student);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id)
	{
		repo.deleteById(id);
	}
}
