package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UpdateBus;
import com.lti.entity.Bus;
import com.lti.exception.BusServiceException;
import com.lti.service.BusService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private BusService service;
	
	@PostMapping(path="/addbus")
	public String addBusType(@RequestBody Bus newBus) {
		try {
			service.addBus(newBus);
			return "Bus Added Successfully";
		} catch (BusServiceException e) {
			return e.getMessage();
		}
	}
	
	@PutMapping(path="/updateBusRoute")
	public String updateBusStatus(@RequestBody UpdateBus updateBus) {

		try {
			service.updateBusRoute(updateBus);
			return "update success";
		} catch (BusServiceException e) {
			return e.getMessage();
		}
	}

}
