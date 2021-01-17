package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Booking;
import com.lti.service.TripService;



@RestController
@CrossOrigin
public class TripController {
	
	
	 @Autowired
	    private TripService tripService;


	    @GetMapping("/myTrips")
	    public @ResponseBody List<Booking> myTrips(@RequestParam int userId){
	        List<Booking> myTrips = tripService.getMyTrips(userId);
	        return myTrips;
	    }
	
	

}
