package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BusSearch;
import com.lti.service.BusService;

@RestController
@CrossOrigin
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@PostMapping("/search")
	public @ResponseBody List<Object[]> searchBusesForRoute(@RequestBody BusSearch bus ) {
		List<Object[]> buses = busService.searchBus(bus.getSource(), bus.getDestination(), bus.getDate());
		return buses;
	}

}
