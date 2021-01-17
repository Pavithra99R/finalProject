package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Booking;
import com.lti.repository.TripRepository;

@Service
@Transactional
public class TripServiceImpl implements TripService {
	
	@Autowired
    private TripRepository tripRepository;

    public List<Booking> getMyTrips(int userId){
        List<Booking> myTrips = tripRepository.fetchByUserId(userId);
        return myTrips;
    }
	

}
