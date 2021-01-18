package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.entity.Users;

@Repository
public class ForgotPassword extends GenericDao{
	public Users fetchUserByEmailId(String email) {
		return (Users)entityManager.createQuery("select u from Users u where u.email =:em")
				.setParameter("em",email)
				.getSingleResult();
	}
}


//hi