package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.entities.Ticket;
import com.matheusmarqs1.flight_booking_api.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public List<Ticket> findAll(){
		return ticketRepository.findAll();
	}
	
	public Ticket findById(Long id) {
		Optional<Ticket> obj =  ticketRepository.findById(id);
		return obj.get();
	}
}
