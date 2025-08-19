package com.matheusmarqs1.flight_booking_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Airport;
import com.matheusmarqs1.flight_booking_api.services.AirportService;

@RestController
@RequestMapping(value = "/airports")
public class AirportResource {
	
	@Autowired
	private AirportService airportService;
	
	@GetMapping
	public ResponseEntity<List<Airport>> findAll(){
		List<Airport> list = airportService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Airport> findById(@PathVariable Long id){
		Airport airport = airportService.findById(id);
		return ResponseEntity.ok().body(airport);
	}
}
