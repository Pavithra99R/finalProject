package com.lti.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.RouteDetails;
import com.lti.dto.UpdateBus;
import com.lti.entity.Bus;
import com.lti.entity.Route;

@Repository
public class RouteBusRepository extends GenericRepository {

	public List<RouteDetails> fetchRouteDetails(String source, String destination, LocalDateTime date) {
		Query q = entityManager
				.createQuery("select r.id,r.source,r.destination,r.fare,to_char(r.dateOfDepature,'hh24:mi:ss'),"
						+ "to_char(r.dateOfArrival,'hh24:mi:ss'),b.busName,b.busType,b.busId,r.seatAvailable"
						+ " from Route r join r.buses b where r.source=:source and r.destination=:destination "
						+ "and r.dateOfDepature >= :date");
		q.setParameter("source", source);
		q.setParameter("destination", destination);
		q.setParameter("date", date);
		List<RouteDetails> list = q.getResultList();
		return list;
	}

	public void updateBus(UpdateBus busRoute) {

		int routeId = busRoute.getRouteId();
		System.out.println(routeId);
		Route route = entityManager.find(Route.class, routeId);
		
		Bus bus = entityManager.find(Bus.class, busRoute.getBusId());
		
		bus.setRoute(route);
		entityManager.merge(bus);
	}

	public void deleteBus(int busId) {
		Bus bus = entityManager.find(Bus.class, busId);
		entityManager.remove(bus);
	}
}
