package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Users;
import com.lti.repository.ChangePasswordRepository;

@Service
@Transactional
public class ChangePasswordServiceImpl implements ChangePasswordService{

	@Autowired
	private ChangePasswordRepository changePasswordRepository;
	
	public void changePassword(String email, String password) {
		 int userId = changePasswordRepository.findUserByEmail(email);
		 Users user = changePasswordRepository.fetch(Users.class, userId);
		 user.setPassword(password);
		 changePasswordRepository.save(user);
		
	}

}
