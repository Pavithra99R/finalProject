
package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegisterStatus;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Users;
import com.lti.exception.UserServiceException;
import com.lti.service.UserInterface;

@CrossOrigin
@RestController
public class Registration {
	
	
	@Autowired
	private UserInterface ui;
	
	@PostMapping("/register")
	public @ResponseBody RegisterStatus register(@RequestBody Users users) {
	try {
	int id = ui.register(users);
	RegisterStatus status = new RegisterStatus();
	status.setStatus(StatusType.SUCCESS);
	status.setMessage("Registration Successful!");
	status.setRegisterUserId(id);
	return status;
	}
	catch(UserServiceException e) {
	RegisterStatus status = new RegisterStatus();
	status.setStatus(StatusType.FAILED);
	status.setMessage(e.getMessage());
	return status;
	}
	}
}
