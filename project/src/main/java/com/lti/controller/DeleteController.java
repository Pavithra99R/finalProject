package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DeleteBus;
import com.lti.service.BusService;

@RestController
@CrossOrigin
public class DeleteController {

	@Autowired
	private BusService service; 
	
	@DeleteMapping(path="/deleteBus")
	public String deleteBus(@RequestBody DeleteBus delete) {
		try {
			service.deleteBus(delete.getBusId());
			return "Bus deleted succesfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
