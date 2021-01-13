package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends GenericRepository {
	
	public boolean isCustomerPresent(String email) {
		return (Long)
				entityManager
				.createQuery("select count(u.userId) from Users u where u.email = :email")
				.setParameter("email", email)
				.getSingleResult() == 1 ? true : false;
	}
	
	public int findByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select u.userId from Users u where u.email = :email and u.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
	}

}
