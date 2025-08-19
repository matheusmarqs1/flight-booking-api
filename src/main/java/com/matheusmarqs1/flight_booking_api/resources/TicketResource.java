package com.matheusmarqs1.flight_booking_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusmarqs1.flight_booking_api.entities.Ticket;
import com.matheusmarqs1.flight_booking_api.services.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> findAll(){
		List<Ticket> list = ticketService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Long id){
		Ticket ticket = ticketService.findById(id);
		return ResponseEntity.ok().body(ticket);
	}
}
