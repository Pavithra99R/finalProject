package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.RouteDetails;
import com.lti.dto.UpdateBus;
import com.lti.entity.Bus;
import com.lti.exception.BusServiceException;
import com.lti.repository.RouteBusRepository;

@Service
@Transactional
public class BusServiceImpl implements BusService {

	@Autowired
	private RouteBusRepository routeBusRepository;

	public List<RouteDetails> searchBus(String source, String destination, LocalDate date) {
		String[] s = source.split(",");
		String[] d = destination.split(",");
		LocalTime time = LocalTime.of(0, 0);
		List<RouteDetails> buses = routeBusRepository.fetchRouteDetails(s[1], d[1], LocalDateTime.of(date, time));
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
	
	public Customer login(String email, String password) {
		try {
			if(!customerRepository.isCustomerPresent(email))
				throw new CustomerServiceException("Customer not registered!");
			int id = customerRepository.findByEmailAndPassword(email, password);
			Customer customer = customerRepository.fetch(Customer.class, id);
			return customer;
		}
		//catch(EmptyResultDataAccessException e) {
		catch(NoResultException e) {
			throw new CustomerServiceException("Incorrect email/password");
		}
	}

}
