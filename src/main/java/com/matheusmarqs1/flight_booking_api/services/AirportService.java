package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.entities.Airport;
import com.matheusmarqs1.flight_booking_api.repositories.AirportRepository;

@Service
public class AirportService {
	
	@Autowired
	private AirportRepository airportRepository;
	
	public List<Airport> findAll(){
		return airportRepository.findAll();
	}
	
	public Airport findById(Long id) {
		Optional<Airport> obj =  airportRepository.findById(id);
		return obj.get();
	}
}
