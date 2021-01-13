package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.exception.UserServiceException;
import com.lti.entity.Users;
import com.lti.repository.RegistrationRepository;
@Service
@Transactional
public class RegistrationService implements UserInterface{
	@Autowired
	private RegistrationRepository regRepo;
	
	public int register(Users users) {
		if(regRepo.isUserPresent(users.getUserId()))
			throw new UserServiceException("Customer already registered");
		else {
			Users updatedUser = (Users) regRepo.save(users);
			return updatedUser.getUserId();
		}
		
	}

}
