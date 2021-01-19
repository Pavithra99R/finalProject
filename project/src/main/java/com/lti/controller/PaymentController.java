package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PaymentDetails;
import com.lti.dto.PaymentStatus;
import com.lti.exception.BusServiceException;
import com.lti.service.PaymentService;

@RestController
@CrossOrigin
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(path= "/payment")
	public PaymentStatus getPayment(@RequestBody PaymentDetails payment) {
		
		PaymentStatus status = new PaymentStatus();
		try {
			int transactionId=paymentService.makePayment(payment);
			status.setTrasactionId(transactionId);
			status.setStatus("Payment Success");
			return status;
		}
		catch (BusServiceException e) {
			return status;
		}
		
	}
	

}
