package com.matheusmarqs1.flight_booking_api.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;

@RestController
@RequestMapping(value = "/passengers")
public class PassengerResource {
	 
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@GetMapping
	public ResponseEntity<Passenger> findAll(){
		Passenger passenger = new Passenger(1L, "Alex Pereira", "alex@example.com", "12345678909", LocalDate.parse("10/05/1974", FORMATTER), "999999999");
		return ResponseEntity.ok().body(passenger);
	}
}
