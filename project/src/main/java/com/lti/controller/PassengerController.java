package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookingDetails;
import com.lti.dto.BookingStatus;
import com.lti.dto.Status.StatusType;
import com.lti.exception.BusServiceException;
import com.lti.service.BookingService;

@RestController
@CrossOrigin
public class PassengerController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/passenger")
	public @ResponseBody BookingStatus bookForPassengers(@RequestBody BookingDetails bookingDetails) {
	
		BookingStatus status = new BookingStatus();
		try {
			int ticketId = bookingService.booking(bookingDetails);
			status.setTicketId(ticketId);
			return status;
		}
		catch (BusServiceException e) {
		    return status;
		}
	}

}
