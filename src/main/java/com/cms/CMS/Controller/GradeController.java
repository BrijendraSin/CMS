package com.cms.CMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.CMS.dao.GradeDAO;
import com.cms.CMS.entity.Grade;

@RestController
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	GradeDAO gradeRepo;
	
	@PostMapping("/add")
	public Grade addGrade(@RequestBody Grade grade) {
		
		return gradeRepo.save(grade);
	}
}
