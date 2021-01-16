package com.lti.test;

import java.util.List;

//import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.RouteBus;

public class RouteBusTest {
	
	//@Test
	public void getBusForRoute() {
		
		RouteBus dao = new RouteBus();
		List<Object[]> buses = dao.fetchBusForRoute("Chennai", "Kerala");
		for(Object[] b:buses) {
			System.out.println(b[0]);
			System.out.println(b[1]);
			System.out.println(b[2]);
		}
		
	}

}
