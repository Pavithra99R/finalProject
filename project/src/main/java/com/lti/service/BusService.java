package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.dto.RouteDetails;
import com.lti.dto.UpdateBus;
import com.lti.entity.Bus;

public interface BusService {

	public List<RouteDetails> searchBus(String source, String destination, LocalDate date);

	public void addBus(Bus newBus);

	public void updateBusRoute(UpdateBus bus);

	public void deleteBus(int busId);

}
