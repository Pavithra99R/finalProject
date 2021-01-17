package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Users;
import com.lti.repository.GenericRepository;

@Service
@Transactional
public class UpdateprofileServiceImpl implements UpdateProfileService {
	
	@Autowired
	private GenericRepository genericRepository;
	
	public void updateprofile(Users user) {
		
		Users u = genericRepository.fetch(Users.class, user.getUserId());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setContact(user.getContact());
		u.setDob(user.getDob());
		genericRepository.save(u);
		
	}

}
