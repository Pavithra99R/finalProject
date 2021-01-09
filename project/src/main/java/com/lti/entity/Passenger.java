package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_passenger_seq")
	@SequenceGenerator(sequenceName = "passenger_seq", allocationSize = 1, name = "my_passenger_seq")
	@Column(name="passenger_id")

	private int passengerId;
	
	@Column(name = "passenger_name")
	private String passengerName;
	
	@Column(name = "passenger_age")
	private int passengerAge;
	
	@Column(name="passenger_age")
	private String passengerGender;
	
	@Column(name= "seat_no")
	private int seatNo;

	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Booking booking;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
