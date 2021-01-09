package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW")
public class Review {
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="BUS_ID")
	private int busId;
	
	@Column(name="RATING")
	private int rating;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
