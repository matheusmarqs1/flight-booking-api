package com.matheusmarqs1.flight_booking_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Reservation;
import com.matheusmarqs1.flight_booking_api.services.ReservationService;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationResource {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public ResponseEntity<List<Reservation>> findAll(){
		List<Reservation> list = reservationService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reservation> findById(@PathVariable Long id){
		Reservation reservation = reservationService.findById(id);
		return ResponseEntity.ok().body(reservation);
	}
}
