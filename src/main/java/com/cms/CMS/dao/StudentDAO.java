package com.cms.CMS.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cms.CMS.entity.Student;

public interface StudentDAO extends CrudRepository<Student, Integer> {

public Student save(Student pro);
	
	public List<Student> findAll();
	
}
