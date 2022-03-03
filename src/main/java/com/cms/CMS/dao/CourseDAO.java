package com.cms.CMS.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cms.CMS.entity.Course;

public interface CourseDAO extends CrudRepository<Course, Integer>{

public Course save(Course course);
	
	public List<Course> findAll();
}
