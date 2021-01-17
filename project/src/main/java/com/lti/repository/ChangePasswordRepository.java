package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ChangePasswordRepository extends GenericRepository {
	
	public int findUserByEmail(String email) {
		return (Integer)
				entityManager
				.createQuery("select u.userId from Users u where u.email = :email")
				.setParameter("email", email)
				.getSingleResult();
	}

}
