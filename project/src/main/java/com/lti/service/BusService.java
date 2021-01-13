package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.entity.Route;

public interface BusService {
	
	public List<Route> searchBus(String source,String destination,LocalDate date);
	
	


}
