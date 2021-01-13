package com.lti.dto;

import java.util.List;

import com.lti.entity.Passenger;

public class BookingDetails {

	private int routeId;
	private int userId;
	private String boarding;
	private String droping;
	private double fare;
	private List<Passenger> passengers;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getDroping() {
		return droping;
	}

	public void setDroping(String droping) {
		this.droping = droping;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}
