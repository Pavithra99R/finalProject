package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.PaymentDetails;
import com.lti.entity.Booking;
import com.lti.entity.Payment;
import com.lti.entity.User;
import com.lti.exception.BusServiceException;
import com.lti.repository.RouteBusRepository;

@Service
@Transactional
public class PaymentService {
	

	@Autowired
	private RouteBusRepository routeBusRepository;

	public int makePayment(PaymentDetails paymentDetails) {
		try {
			Booking booking = routeBusRepository.fetch(Booking.class, paymentDetails.getTicketId());
			booking.setPaidDate(LocalDateTime.now());
			booking.setStatus("Confirm");
			Payment payment = new Payment();
			payment.setBooking(booking);
			
			User user = routeBusRepository.fetch(User.class, paymentDetails.getUserId());
			payment.setUser(user);
			
			payment.setAmountPaid(paymentDetails.getAmount());
			booking.setAmount(paymentDetails.getAmount());

			payment.setPaymentdate(LocalDate.now());
			payment.setStatus("paid");
			payment.setPaymenttype(paymentDetails.getPaymentType());
			
			Payment paymentId = (Payment)routeBusRepository.save(payment);
			routeBusRepository.save(booking);
			
			return paymentId.getTransactionId();
			
		} catch (Exception e) {
			throw new BusServiceException("Invalid Entry,Failed to Book Ticket!!");
		}
		
	}
	
}
