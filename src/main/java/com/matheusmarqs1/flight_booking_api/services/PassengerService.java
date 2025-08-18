package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;
import com.matheusmarqs1.flight_booking_api.repositories.PassengerRepository;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public List<Passenger> findAll(){
		return passengerRepository.findAll();
	}
	
	public Passenger findById(Long id) {
		Optional<Passenger> obj =  passengerRepository.findById(id);
		return obj.get();
	}
}
