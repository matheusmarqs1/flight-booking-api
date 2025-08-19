package com.matheusmarqs1.flight_booking_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Flight;
import com.matheusmarqs1.flight_booking_api.services.FlightService;

@RestController
@RequestMapping(value = "/flights")
public class FlightResource {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping
	public ResponseEntity<List<Flight>> findAll(){
		List<Flight> list = flightService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Flight> findById(@PathVariable Long id){
		Flight flight = flightService.findById(id);
		return ResponseEntity.ok().body(flight);
	}
}
