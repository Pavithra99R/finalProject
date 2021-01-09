package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public Object save(Object obj) {

		Object updateObj = entityManager.merge(obj);
		return updateObj;

	}

	public <E> E fetch(Class<E> cls, Object pk) {

		E e = entityManager.find(cls, pk);
		return e;
	}

	
}
