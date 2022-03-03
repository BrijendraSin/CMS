package com.cms.CMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.CMS.dao.CollegeDAO;
import com.cms.CMS.entity.College;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeDAO collegeRepo;
	
	@PostMapping("/add")
	public College addCollege(@RequestBody College college) {
		
		return collegeRepo.save(college);
	}
}
