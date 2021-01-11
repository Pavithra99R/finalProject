package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.dto.RouteDetails;

public interface BusService {
	
	public List<RouteDetails> searchBus(String source,String destination,LocalDate date);

}
