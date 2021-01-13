package com.lti.service;

import com.lti.entity.Users;


public interface CustomerService {
	
	public Users login(String email, String password);
	public Users get(int id);

}
