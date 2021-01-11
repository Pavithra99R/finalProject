package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BusSearch;
import com.lti.dto.RouteDetails;
import com.lti.service.BusService;

@RestController
@CrossOrigin
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@PostMapping("/search")
	public @ResponseBody List<RouteDetails> searchBusesForRoute(@RequestBody BusSearch bus ) {
		List<RouteDetails> buses = busService.searchBus(bus.getSource(), bus.getDestination(), bus.getDate());
		return buses;
	}

}
