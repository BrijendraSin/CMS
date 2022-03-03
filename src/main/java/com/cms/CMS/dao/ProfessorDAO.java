package com.cms.CMS.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cms.CMS.entity.Professor;


public interface ProfessorDAO extends CrudRepository<Professor, Integer> {
	 
	public Professor save(Professor pro);
	
	public List<Professor> findAll();
	
	
}
