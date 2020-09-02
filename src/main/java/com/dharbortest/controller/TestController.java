package com.dharbortest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dharbortest.dao.CourseRepo;
import com.dharbortest.dao.StudentRepo;

@Controller
public class TestController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@GetMapping("/greet")
	public String greet()
	{
		return "Students:" + studentRepo.count() + " Classes:" + courseRepo.count();
	}
}
