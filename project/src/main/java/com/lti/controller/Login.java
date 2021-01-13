package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Logindto;
import com.lti.dto.Status.StatusType;
import com.lti.dto.Loginstatus;
import com.lti.entity.Users;
import com.lti.exception.CustomerServiceException;
import com.lti.service.CustomerService;




@RestController
@CrossOrigin
public class Login {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/login")
	public Loginstatus login(@RequestBody Logindto Login) {
		try {
			Users customer = customerService.login(Login.getEmail(), Login.getPassword());
			Loginstatus status = new Loginstatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Login Successful!");
			status.setCustomerId(customer.getUserId());
			status.setCustomerName(customer.getFirstName());
			return status;
		}
		catch(CustomerServiceException e) {
			Loginstatus status = new Loginstatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;			
		}
	}
	
	

}
