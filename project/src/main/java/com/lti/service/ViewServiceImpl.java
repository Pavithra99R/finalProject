package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Users;
import com.lti.repository.GenericRepository;
@Service
@Transactional
public class ViewServiceImpl implements ViewService{
	
	@Autowired
	private GenericRepository genericRepository;
	
	public void viewProfile(Users user,int userId) {
		Users u=new Users();
		u=genericRepository.fetch(Users.class,userId);
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		
		
		genericRepository.save(u);
		
	}

}
