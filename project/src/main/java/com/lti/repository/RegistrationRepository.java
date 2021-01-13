package com.lti.repository;

import org.springframework.stereotype.Repository;


	@Repository
	public class RegistrationRepository extends GenericRepository{
		
		public boolean isUserPresent(int userId) {
			return (Long)
					entityManager
					.createQuery("select count(c) from Users c where c.userId = :userId")
					.setParameter("userId", userId)
					.getSingleResult() == 1 ? true : false;
		}
	
}
