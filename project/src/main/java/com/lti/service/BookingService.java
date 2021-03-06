package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.BookingDetails;
import com.lti.entity.Booking;
import com.lti.entity.Passenger;
import com.lti.entity.Route;
import com.lti.entity.User;
import com.lti.exception.BusServiceException;
import com.lti.repository.RouteBusRepository;

@Service
@Transactional
public class BookingService {

	@Autowired
	private RouteBusRepository routeBusRepository;

	public int booking(BookingDetails bookingDetails) {

		try {
			Route route = routeBusRepository.fetch(Route.class, bookingDetails.getRouteId());
			Booking booking = new Booking();
			booking.setRoute(route);
			booking.setBoarding(bookingDetails.getBoarding());
			booking.setDroping(bookingDetails.getDroping());
			booking.setAmount(bookingDetails.getFare());
			booking.setStatus("Payment Pending");
			
			User user = routeBusRepository.fetch(User.class, bookingDetails.getUserId());
			booking.setUser(user);

			booking.setPassengers(bookingDetails.getPassengers());

			for (Passenger passenger : bookingDetails.getPassengers()) {
				passenger.setBooking(booking);
			}
			
			Booking updatedBooking= (Booking) routeBusRepository.save(booking);
			return updatedBooking.getTicketId();
			
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry,Can't proceed!!");
		}
		
	}
}
