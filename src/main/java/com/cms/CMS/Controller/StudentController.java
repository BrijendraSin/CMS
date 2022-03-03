package com.cms.CMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.CMS.dao.StudentDAO;
import com.cms.CMS.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentDAO studentRepo;
	
	@PostMapping("/add")
	public Student addProfessor(@RequestBody Student student) {
		
		return studentRepo.save(student);
}}
