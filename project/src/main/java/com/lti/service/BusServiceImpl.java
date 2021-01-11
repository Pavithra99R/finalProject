package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.repository.RouteBusRepository;

@Service
@Transactional
public class BusServiceImpl implements BusService {
	
	@Autowired
	private RouteBusRepository routeBusRepository;

	public List<Object[]> searchBus(String source, String destination, LocalDate date) {
		LocalTime time = LocalTime.of(0, 0);
		List<Object[]> buses = routeBusRepository.fetchRouteDetails(source, destination, LocalDateTime.of(date, time));
		return buses;
	}

}
