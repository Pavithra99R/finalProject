package com.lti.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.dto.StopDetails;
import com.lti.entity.Stop;

@Repository
public class StopsRepository extends GenericRepository {

	public List<StopDetails> fetchStopDetails(String city, int routeId) {

		Query q = entityManager.createQuery("select s.stop,s.city,to_char(s.time,'dd-mm'),to_char(s.time,'hh24:mi:ss'),"
				+ " r.id from Stop s join s.route r where s.city=:source and r.id=:routeId");
		q.setParameter("source", city);
		q.setParameter("routeId", routeId);
		List<StopDetails> stops = q.getResultList();
		return stops;

	}

	public List<Stop> fetchStopDetailsNew(String city, int routeId) {

		Query q = entityManager.createQuery("select s "
				+ "  from Stop s join s.route r where s.city=:source and r.id=:routeId");
		q.setParameter("source", city);
		q.setParameter("routeId", routeId);
		List<Stop> stops = q.getResultList();
		return stops;

	}

}
