package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.MailSendService;

@RestController
public class HelloController {
	
	@Autowired
	private MailSendService mailService;
	
//	@GetMapping("/hello")
//	public String sayHello() {
//		return "it  is working";
//	}
	
//	@RequestMapping("/hello")
//	public String mail() {
//		mailService.sendMail();
//		return "Success";
//	}
//	
	

}
