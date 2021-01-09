package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stops")
public class Stop {
	
	@Id
	@GeneratedValue
	@Column(name="stop_id")
	private int stopId;
	
	@Column(name="city")
	private String city;
	
	@Column(name="stop")
	private String stop;
	
	@Column(name="time")
	private LocalDateTime time;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	

}
