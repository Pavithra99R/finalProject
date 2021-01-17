package com.lti.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Booking;


@Repository
public class TripRepository extends GenericRepository{
	

    public List<Booking> fetchByUserId(int userId){
    	
        Query q = entityManager.createQuery("select b from Booking b join b.user u where u.userId=:userId");
        q.setParameter("userId",userId);
        List<Booking> myTrips= q.getResultList();
        return myTrips;
        
    }

}
