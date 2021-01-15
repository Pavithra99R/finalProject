package com.lti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.Booking;

@Repository
public class CancelTicketRepository extends GenericRepository{
	
	@Autowired
	private GenericRepository genericRepository;
	
	public void cancelTicket(int ticketId) {
		
		
		
	}

}
