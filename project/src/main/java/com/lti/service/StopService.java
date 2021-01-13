package com.lti.service;

import java.util.List;

import com.lti.entity.Stop;

public interface StopService {
	
	public List<Stop> searchStops(String city,int routeId);

}
