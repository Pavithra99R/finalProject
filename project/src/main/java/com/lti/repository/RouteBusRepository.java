package com.lti.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class RouteBusRepository extends GenericRepository{
	
	public List<Object[]> fetchRouteDetails(String source,String destination,LocalDateTime date){
		Query q = entityManager.createQuery("select r.source,r.destination,r.fare,to_char(r.dateOfDepature,'hh24:mi:ss'),"
				+ "to_char(r.dateOfArrival,'hh24:mi:ss'),b.busName,b.busType,b.busId,r.seatAvailable"
				+ " from Route r join r.buses b where r.source=:source and r.destination=:destination "
				+ "and r.dateOfDepature >= :date");
		q.setParameter("source", source);
		q.setParameter("destination", destination);
		q.setParameter("date", date);
		List<Object[]> list = q.getResultList();
		return list;
	}

}
