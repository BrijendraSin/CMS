package com.cms.CMS.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cms.CMS.entity.College;

public interface CollegeDAO extends CrudRepository<College, Integer>{

	public College save(College collele);
	
	public List<College> findAll();
	
}
