package com.cms.CMS.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cms.CMS.entity.Grade;

public interface GradeDAO extends CrudRepository<Grade, Integer>{


	public Grade save(Grade grade);
	
	public List<Grade> findAll();
	
}
