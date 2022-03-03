package com.cms.CMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.CMS.dao.CourseDAO;
import com.cms.CMS.entity.Course;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseDAO courseRepo;
	
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		
		return courseRepo.save(course);
	}
}
