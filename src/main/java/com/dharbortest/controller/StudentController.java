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

import com.dharbortest.dao.StudentRepo;
import com.dharbortest.model.Student;

@RestController
@RequestMapping("Student")
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping
	public List<Student> list(){
		return repo.findAll();
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
	
	@DeleteMapping(value="/id")
	public void eliminar(@PathVariable("id") Integer id)
	{
		repo.deleteById(id);
	}
}
