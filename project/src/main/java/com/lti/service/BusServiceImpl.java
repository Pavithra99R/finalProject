package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.AddStop;
import com.lti.dto.UpdateBus;
import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;
import com.lti.entity.Stop;
import com.lti.exception.BusServiceException;
import com.lti.repository.RouteBusRepository;

@Service
@Transactional
public class BusServiceImpl implements BusService {

	@Autowired
	private RouteBusRepository routeBusRepository;

	public List<Route> searchBus(String source, String destination, LocalDate date) {
		String[] s = source.split(",");
		String[] d = destination.split(",");
		LocalTime time = LocalTime.of(0, 0);
		List<Route> buses = routeBusRepository.fetchRouteDetails(s[1], d[1], LocalDateTime.of(date, time));
		return buses;

	}

	public void addBus(Bus newBus) {
		try {
			routeBusRepository.save(newBus);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry,Bus cannot be added!!");
		}

	}

	public void updateBusRoute(UpdateBus bus) {

		try {
			routeBusRepository.updateBus(bus);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusServiceException("Invalid entry, Bus Route cannot be updated ");
		}

	}

	public void deleteBus(int busId) {
		try {
			routeBusRepository.deleteBus(busId);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Bus Status cannot be deleted ");
		}
	}

	public Admin login(String email, String password) {
		try {
			if (!routeBusRepository.isAdminAuthorized(email)) {
				throw new BusServiceException("Restricted Login");
			}
			int id = routeBusRepository.findByEmailAndPassword(email, password);
			Admin admin = routeBusRepository.fetch(Admin.class, id);
			return admin;
		} catch (NoResultException e) {
			throw new BusServiceException("Incorrect email/password");
		}

	}

	public void addRoute(Route newRoute) {
		try {
			routeBusRepository.save(newRoute);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Route cannot be added ");
		}
	}

	public void addStop(AddStop newStop) {
		try {

			Route route = routeBusRepository.fetch(Route.class, newStop.getRouteId());
			route.setStops(newStop.getStops());

			for (Stop stop : newStop.getStops()) {
				stop.setRoute(route);
			}
			routeBusRepository.save(route);
		} catch (Exception e) {
			throw new BusServiceException("Invalid entry, Stop cannot be added ");
		}
	}

	public List<Bus> viewBus() {
		List<Bus> buses = routeBusRepository.fetchBusList();

		return buses;
	}

	public List<Object[]> viewRoute() {
		List<Object[]> routes = routeBusRepository.fetchRoutes();
		return routes;
	}

}
