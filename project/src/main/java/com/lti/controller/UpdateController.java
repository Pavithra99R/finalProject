package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Users;
import com.lti.service.UpdateProfileService;

@RestController
@CrossOrigin
public class UpdateController {
	
	@Autowired
	private UpdateProfileService updateProfileService;
	
	
	@PostMapping("/updateProfile")
	public @ResponseBody Status updateProfile(@RequestBody Users user) {
		try {
			updateProfileService.updateprofile(user);
			Status status = new Status();
			status.setMessage("Profile Updated Successfully");
			status.setStatus(StatusType.SUCCESS);
			return status;
		}catch(Exception e) {
			Status status = new Status();
			status.setMessage("Profile Updation failed");
			status.setStatus(StatusType.FAILED);
			return status;
		}
		
		
	}

}
