package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.service.ChangePasswordService;

@RestController
@CrossOrigin
public class PasswordController {
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@GetMapping("/changePassword")
	public @ResponseBody Status changePasswordForUser(@RequestParam("email") String email,@RequestParam("pass") String password) {
		try {
			changePasswordService.changePassword(email, password);
			Status status = new Status();
			status.setMessage("Password changed successfully");
			status.setStatus(StatusType.SUCCESS);
			return status;
		}
		catch(Exception e) {
			Status status = new Status();
			status.setMessage("Password change Failed");
			status.setStatus(StatusType.FAILED);
			return status;
		}
	}

}
