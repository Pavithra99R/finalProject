package com.lti.service;

import java.time.LocalDate;
import java.util.List;

public interface BusService {
	
	public List<Object[]> searchBus(String source,String destination,LocalDate date);

}
