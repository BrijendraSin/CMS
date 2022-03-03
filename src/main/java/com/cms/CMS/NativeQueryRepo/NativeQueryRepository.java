package com.cms.CMS.NativeQueryRepo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.cms.CMS.entity.Professor;
import com.cms.CMS.entity.ProfileDetails;

@Service
public class NativeQueryRepository {

	@PersistenceContext
	private EntityManager entity;
	
	public List<ProfileDetails> getProDetsild(int proId, int collegeId){
		Query q = entity.createNativeQuery("select * from public.fn_get_student_course_grade(?1,?2)", ProfileDetails.class);
		q.setParameter(1, proId);
		q.setParameter(2, collegeId);
		List<ProfileDetails> p =  q.getResultList();
		return p;
	}
	
	
}
