package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookingDetails;
import com.lti.exception.BusServiceException;
import com.lti.service.BookingService;

@RestController
@CrossOrigin
public class PassengerController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/passenger")
	public @ResponseBody String bookForPassengers(@RequestBody BookingDetails bookingDetails) {
	
		try {
			bookingService.booking(bookingDetails);
			return "Ticket Booked Successfully";
		}
		catch (BusServiceException e) {
			return e.getMessage();
		}
	}

}
