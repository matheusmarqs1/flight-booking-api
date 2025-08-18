package com.matheusmarqs1.flight_booking_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;
import com.matheusmarqs1.flight_booking_api.services.PassengerService;

@RestController
@RequestMapping(value = "/passengers")
public class PassengerResource {
	
	@Autowired
	private PassengerService passengerService;
	
	@GetMapping
	public ResponseEntity<List<Passenger>> findAll(){
		List<Passenger> list = passengerService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Passenger> findById(@PathVariable Long id){
		Passenger passenger = passengerService.findById(id);
		return ResponseEntity.ok().body(passenger);
	}
}
