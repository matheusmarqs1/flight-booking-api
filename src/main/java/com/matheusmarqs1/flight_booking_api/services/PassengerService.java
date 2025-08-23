package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerCreateRequest;
import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerResponse;
import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerUpdateRequest;
import com.matheusmarqs1.flight_booking_api.entities.Passenger;
import com.matheusmarqs1.flight_booking_api.repositories.PassengerRepository;

import jakarta.transaction.Transactional;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public List<PassengerResponse> findAll(){
		List<Passenger> list = passengerRepository.findAll();
		return list.stream().map(PassengerResponse::fromEntity).collect(Collectors.toList());
	}
	
	public PassengerResponse findById(UUID id) {
		Optional<Passenger> obj =  passengerRepository.findById(id);
		return PassengerResponse.fromEntity(obj.get());
	}
	
	@Transactional
	public PassengerResponse insert(PassengerCreateRequest obj) {
		Passenger passenger = new Passenger(
				null, 
				obj.name(), 
				obj.email(), 
				obj.cpf(), 
				obj.birthDate(), 
				obj.phone()
		);
		Passenger createdPassenger = passengerRepository.save(passenger);
		return PassengerResponse.fromEntity(createdPassenger);
	}
	
	@Transactional
	public PassengerResponse update(UUID id, PassengerUpdateRequest obj) {
		Passenger existingPassenger = passengerRepository.getReferenceById(id);
		
		existingPassenger.setName(obj.name());
		existingPassenger.setEmail(obj.email());
		existingPassenger.setCpf(obj.cpf());
		existingPassenger.setBirthDate(obj.birthDate());
		existingPassenger.setPhone(obj.phone());
		
		Passenger updatedPassenger = passengerRepository.save(existingPassenger);
		return PassengerResponse.fromEntity(updatedPassenger);
		
	}
	
	@Transactional
	public void delete(UUID id) {
		passengerRepository.deleteById(id);
	}
	
}
