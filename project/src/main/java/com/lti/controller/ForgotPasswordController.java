package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.service.PasswordService;

@RestController
@CrossOrigin
public class ForgotPasswordController {
	
	@Autowired
	private PasswordService passwordService;
	
	@GetMapping("/forgotPassword")
	public @ResponseBody Status forgotPassword(@RequestParam("email") String email) {
		try {
			passwordService.forgotPassword(email);
			Status status = new Status();
			status.setMessage("Reset Password Link sent to your mail");
			status.setStatus(StatusType.SUCCESS);
			return status;
		}
		catch(Exception e) {
			Status status = new Status();
			status.setMessage("Something went Wrong!");
			status.setStatus(StatusType.FAILED);
			return status;
		}
		
		
	}
}
