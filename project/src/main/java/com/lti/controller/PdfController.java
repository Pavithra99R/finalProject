package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.TicketPdfService;

@RestController
@CrossOrigin
public class PdfController {
	
	@Autowired
	private TicketPdfService ticketService;
	
	@GetMapping("/createPdf")
	public @ResponseBody String sendMail(@RequestParam("id") int id,@RequestParam("email") String email) {
		ticketService.ticketPdf(id,email);
		return "Sucessfully sent";
	}

}
