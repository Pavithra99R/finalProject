package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.dto.View;
import com.lti.exception.UserServiceException;
import com.lti.service.ViewService;

@RestController
@CrossOrigin
public class ViewController {
	
	@Autowired
	private ViewService viewService;
	
	@PostMapping("/view")
	public @ResponseBody Status updateProfile(@RequestBody View view) {
		try {
			viewService.viewProfile(view.getUser(),view.getUserId());
		Status status=new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Registration Successful!");
		return status;
		}
		catch(UserServiceException e) {
		Status status = new Status();
		status.setStatus(StatusType.FAILED);
		status.setMessage(e.getMessage());
		return status;
		}
		}

}
