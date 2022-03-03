package com.cms.CMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.CMS.NativeQueryRepo.NativeQueryRepository;
import com.cms.CMS.dao.ProfessorDAO;
import com.cms.CMS.entity.Professor;
import com.cms.CMS.entity.ProfileDetails;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	ProfessorDAO professorRepo;
	
	@Autowired
	NativeQueryRepository nativeQuery;
	
	@PostMapping("/add")
	public Professor addProfessor(@RequestBody Professor professor) {
		
		return professorRepo.save(professor);
	}
	
	@GetMapping("/getPro/{proId}/{collegeId}")
	public List<ProfileDetails> getPro(@PathVariable("proId") int proId, @PathVariable("collegeId") int collegeId) {
		return nativeQuery.getProDetsild(proId, collegeId);
	}
}
