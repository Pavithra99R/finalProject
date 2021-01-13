package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Stop;
import com.lti.repository.StopsRepository;

@Service
@Transactional
public class StopServiceImpl implements StopService {
	
	@Autowired
	private StopsRepository stopsRepository;

	public List<Stop> searchStops(String city,int routeId) {
		List<Stop> stops = stopsRepository.fetchStopDetailsNew(city,routeId);
		return stops;
	}

}
