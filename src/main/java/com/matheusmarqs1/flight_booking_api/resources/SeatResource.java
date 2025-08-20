package com.matheusmarqs1.flight_booking_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Seat;
import com.matheusmarqs1.flight_booking_api.services.SeatService;

@RestController
@RequestMapping(value = "/seats")
public class SeatResource {
	
	@Autowired
	private SeatService seatService;
	
	@GetMapping
	public ResponseEntity<List<Seat>> findAll(){
		List<Seat> list = seatService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Seat> findById(@PathVariable Long id){
		Seat seat = seatService.findById(id);
		return ResponseEntity.ok().body(seat);
	}
}
