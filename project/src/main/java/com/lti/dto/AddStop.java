package com.lti.dto;

import java.util.List;

import com.lti.entity.Stop;

public class AddStop extends Stop {

	private int routeId;
	List<Stop> stops;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

}
