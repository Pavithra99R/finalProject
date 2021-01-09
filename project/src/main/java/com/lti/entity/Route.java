package com.lti.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue
	@Column(name = "roue_id")
	private int id;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "fare")
	private double fare;

	@Column(name = "duration")
	private String duration;

	@Column(name = "date_of_depature")
	private LocalDateTime dateOfDepature;

	@Column(name = "date_of_arrival")
	private LocalDateTime dateOfArrival;

	
	@Column(name = "seat_aval")
	private int seatAvailable;

	@OneToMany(mappedBy="route")
	private List<Stop> stops;
	
	

}
