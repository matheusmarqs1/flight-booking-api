package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.entities.Reservation;
import com.matheusmarqs1.flight_booking_api.repositories.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}
	
	public Reservation findById(Long id) {
		Optional<Reservation> obj =  reservationRepository.findById(id);
		return obj.get();
	}
}
