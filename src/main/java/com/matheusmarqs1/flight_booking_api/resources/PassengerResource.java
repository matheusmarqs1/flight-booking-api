package com.matheusmarqs1.flight_booking_api.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerCreateRequest;
import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerResponse;
import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerUpdateRequest;
import com.matheusmarqs1.flight_booking_api.services.PassengerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/passengers")
public class PassengerResource {
	
	@Autowired
	private PassengerService passengerService;
	
	@GetMapping
	public ResponseEntity<List<PassengerResponse>> findAll(){
		List<PassengerResponse> list = passengerService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PassengerResponse> findById(@PathVariable UUID id){
		PassengerResponse passenger = passengerService.findById(id);
		return ResponseEntity.ok().body(passenger);
	}
	
	@PostMapping
	public ResponseEntity<PassengerResponse> insert(@Valid @RequestBody PassengerCreateRequest obj){
		PassengerResponse passenger = passengerService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(passenger.id()).toUri();
		return ResponseEntity.created(uri).body(passenger);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PassengerResponse> update(@PathVariable UUID id, @Valid @RequestBody PassengerUpdateRequest obj){
		PassengerResponse passenger = passengerService.update(id, obj);
		return ResponseEntity.ok().body(passenger);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		passengerService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
