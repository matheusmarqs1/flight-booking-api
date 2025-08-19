package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.entities.Airline;
import com.matheusmarqs1.flight_booking_api.repositories.AirlineRepository;

@Service
public class AirlineService {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	public List<Airline> findAll(){
		return airlineRepository.findAll();
	}
	
	public Airline findById(Long id) {
		Optional<Airline> obj =  airlineRepository.findById(id);
		return obj.get();
	}
}
