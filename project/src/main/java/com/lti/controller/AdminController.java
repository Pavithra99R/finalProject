package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddStop;
import com.lti.dto.AdminLogin;
import com.lti.dto.AdminLoginStatus;
import com.lti.dto.Status.StatusType;
import com.lti.dto.UpdateBus;
import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;
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
	
	@PostMapping("/admin")
	public AdminLoginStatus login(@RequestBody AdminLogin login) {
		try {
			Admin admin = service.login(login.getEmail(),login.getPassword());
			AdminLoginStatus status = new AdminLoginStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Login Successful!");
			status.setId(admin.getId());
			status.setName(admin.getName());
			return status;
		}
		catch(BusServiceException e) {
			AdminLoginStatus status = new AdminLoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;			
		}
	}

	@PostMapping("/addroute")
	public String addRoute(@RequestBody Route newRoute) {
		try {
			service.addRoute(newRoute);
			return "Route added successfully";
		} catch (BusServiceException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping("/addstop")
	public String addStop(@RequestBody AddStop newStop) {
		try {
			service.addStop(newStop);
			return "Stop added successfully";
		}catch (BusServiceException e) {
			return e.getMessage();
		}
		
	}
}
