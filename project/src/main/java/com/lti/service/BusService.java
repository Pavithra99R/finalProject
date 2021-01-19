package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.dto.AddStop;
import com.lti.dto.UpdateBus;
import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;

public interface BusService {


	public void addBus(Bus newBus);

	public void updateBusRoute(UpdateBus bus);

	public void deleteBus(int busId);
	
	public List<Route> searchBus(String source,String destination,LocalDate date);
	
	public Admin login(String email, String password);

	public void addRoute(Route newRoute);

	public void addStop(AddStop newStop);
	
	public List<Bus> viewBus();
	
	public List<Object[]> viewRoute();
}
