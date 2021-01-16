package com.lti.dto;

import com.lti.entity.Users;

public class View {
	private int userId;
	private Users user;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

}
