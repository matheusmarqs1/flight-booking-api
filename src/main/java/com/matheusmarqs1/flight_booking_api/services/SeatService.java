package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.entities.Seat;
import com.matheusmarqs1.flight_booking_api.repositories.SeatRepository;

@Service
public class SeatService {
	
	@Autowired
	private SeatRepository seatRepository;
	
	public List<Seat> findAll(){
		return seatRepository.findAll();
	}
	
	public Seat findById(Long id) {
		Optional<Seat> obj =  seatRepository.findById(id);
		return obj.get();
	}
}
