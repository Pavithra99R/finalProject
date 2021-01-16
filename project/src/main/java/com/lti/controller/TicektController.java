package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.service.CancelTicketService;

@RestController
@CrossOrigin
public class TicektController {
	
	@Autowired
	private CancelTicketService cancelTicketService;
	
	@GetMapping("/cancel")
	public @ResponseBody Status cancelTicketForTrip(@RequestParam("ticketId")int ticketId) {
		try {
			cancelTicketService.cancelTicket(ticketId);
			Status status = new Status();
			status.setMessage("Ticket Cancelled Successfully");
			status.setStatus(StatusType.SUCCESS);
			return status;
		}catch(Exception e) {
			Status status = new Status();
			status.setMessage("Ticket Cancellation Failed");
			status.setStatus(StatusType.FAILED);
			return status;
		}
	}

}
