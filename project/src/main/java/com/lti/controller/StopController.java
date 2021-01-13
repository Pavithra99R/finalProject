package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Stop;
import com.lti.service.StopService;

@RestController
@CrossOrigin
public class StopController {
	
	@Autowired
	private StopService stopService;
	
	@GetMapping("/stops")
	public @ResponseBody List<Stop> searchStopsForCity(@RequestParam("city") String city,@RequestParam("id") int routeId){
		List<Stop> stops = stopService.searchStops(city,routeId);
		return stops;
	}

}
