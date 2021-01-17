package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}

	public <E> E fetch(Class<E> clazz, Object pk) {
		E e = entityManager.find(clazz, pk);
		return e;
	}
	
	public List<?> fetchAll(Class clazz) {
		
		String jpql = "select obj from " + clazz.getName() + " as obj";
		Query q = entityManager.createQuery(jpql);
		 List<?> list = q.getResultList();
		 return list;
		 }
}
