package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Passenger;

@Repository
public class TicketRepository extends GenericRepository {

	public List<Object[]> fetchBookingDetails(int ticketId) {
		Query q = entityManager.createQuery(
				"select b.ticketId,b.boarding,b.droping,b.amount,b.status,to_char(r.dateOfDepature,'yyyy-MM-dd hh24:mi'),r.duration"
						+ " from Route r join r.bookings b where b.ticketId= :ticketId");
		q.setParameter("ticketId", ticketId);
		List<Object[]> list = q.getResultList();
		return list;

	}

	public List<Passenger> fetchPassengerForTrip(int ticketId) {

		Query q = entityManager.createQuery("select p from Passenger p join p.booking b where b.ticketId= :ticketId");
		q.setParameter("ticketId", ticketId);
		List<Passenger> list = q.getResultList();
		return list;

	}

}
