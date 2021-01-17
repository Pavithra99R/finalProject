package com.lti.service;

import java.util.List;

import com.lti.entity.Booking;

public interface TripService {
	
	public List<Booking> getMyTrips (int userId);

}
