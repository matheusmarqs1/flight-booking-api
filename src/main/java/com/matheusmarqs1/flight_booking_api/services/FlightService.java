package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.entities.Flight;
import com.matheusmarqs1.flight_booking_api.repositories.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> findAll(){
		return flightRepository.findAll();
	}
	
	public Flight findById(Long id) {
		Optional<Flight> obj =  flightRepository.findById(id);
		return obj.get();
	}
}
