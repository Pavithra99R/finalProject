package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Booking;
import com.lti.exception.CancellationException;
import com.lti.repository.GenericRepository;

@Service
@Transactional
public class CancelTicketServiceImpl implements CancelTicketService{

	@Autowired
	private GenericRepository genericRepository;
	
	public void cancelTicket(int ticketId) {
		try {
			Booking booking = genericRepository.fetch(Booking.class, ticketId);
			booking.setStatus("Cancelled");
			genericRepository.save(booking);
		}catch(Exception e) {
			throw new CancellationException("Ticket Cancellation failed");
		}
		
		
	}
	
	

}
