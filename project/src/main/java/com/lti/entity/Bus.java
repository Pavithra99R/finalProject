package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Bus")
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_bus_seq")
	@SequenceGenerator(sequenceName = "bus_seq",allocationSize=1,name="my_bus_seq")
	@Column(name = "BUS_ID")
	private int BusId;
	
	@Column(name = "ROUTE_ID")
	private int RouteId;
	
	@Column(name = "BUS_NAME")
	private String BusName;
	
	@Column(name = "BUS_TYPE")
	private String BusType;
	
	@Column(name = "NO_OF_Seats")
	private int NoOfSeats;
	
	
	public int getBusId() {
		return BusId;
	}
	public int getRouteId() {
		return RouteId;
	}
	public String getBusName() {
		return BusName;
	}
	public String getBusType() {
		return BusType;
	}
	public int getNoOfSeats() {
		return NoOfSeats;
	}
	public void setBusId(int busId) {
		BusId = busId;
	}
	public void setRouteId(int routeId) {
		RouteId = routeId;
	}
	public void setBusName(String busName) {
		BusName = busName;
	}
	public void setBusType(String busType) {
		BusType = busType;
	}
	public void setNoOfSeats(int noOfSeats) {
		NoOfSeats = noOfSeats;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
