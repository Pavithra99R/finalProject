package com.lti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Users;
import com.lti.repository.GenericRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private GenericRepository genericRepository;

	public Users fetch(int userId) 
	{

		Users user=genericRepository.fetch(Users.class,userId);
		return user;
		
	}

}
