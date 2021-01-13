package com.lti.service;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.entity.Users;
import com.lti.exception.CustomerServiceException;
import com.lti.repository.CustomerRepository;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService  {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Users login(String email, String password) {
		try {
			if(!customerRepository.isCustomerPresent(email))
				throw new CustomerServiceException("User not registered");
			int id = customerRepository.findByEmailAndPassword(email, password);
			Users customer = customerRepository.fetch(Users.class, id);
			return customer;
		}
	
		catch(NoResultException e) {
			throw new CustomerServiceException("Incorrect email/password");
		}
	}
	
	public Users get(int id) {
		return customerRepository.fetch(Users.class, id);
	}

}
