package com.matheusmarqs1.flight_booking_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Airline;
import com.matheusmarqs1.flight_booking_api.services.AirlineService;

@RestController
@RequestMapping(value = "/airlines")
public class AirlineResource {
	
	@Autowired
	private AirlineService airlineService;
	
	@GetMapping
	public ResponseEntity<List<Airline>> findAll(){
		List<Airline> list = airlineService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Airline> findById(@PathVariable Long id){
		Airline airline = airlineService.findById(id);
		return ResponseEntity.ok().body(airline);
	}
}
