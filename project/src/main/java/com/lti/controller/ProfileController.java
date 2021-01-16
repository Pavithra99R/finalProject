package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lti.entity.Users;
import com.lti.service.ProfileService;

@RestController
@CrossOrigin
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profile")
	public Users fetchProfile(@RequestParam("userId") int userId){
		Users user=profileService.fetch(userId);
		return user;
	}
}
