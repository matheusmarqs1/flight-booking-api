package com.matheusmarqs1.flight_booking_api.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerCreateRequest;
import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerResponse;
import com.matheusmarqs1.flight_booking_api.dtos.passenger.PassengerUpdateRequest;
import com.matheusmarqs1.flight_booking_api.entities.Passenger;
import com.matheusmarqs1.flight_booking_api.repositories.PassengerRepository;
import com.matheusmarqs1.flight_booking_api.services.exceptions.BusinessException;
import com.matheusmarqs1.flight_booking_api.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public List<PassengerResponse> findAll(){
		return passengerRepository.findAll().stream()
				.map(PassengerResponse::fromEntity)
				.collect(Collectors.toList());
	}
	
	public PassengerResponse findById(UUID id) {
		Passenger passenger = getPassengerOrThrow(id);
		return PassengerResponse.fromEntity(passenger);
	}
	
	@Transactional
	public PassengerResponse insert(PassengerCreateRequest obj) {
		passengerRepository.findByCpf(obj.cpf()).ifPresent(passenger -> {
			throw new BusinessException("CPF already registered");
		});
		
		passengerRepository.findByEmail(obj.email()).ifPresent(passenger -> {
			throw new BusinessException("Email already registered");
		});
		
		Passenger passenger = new Passenger(
				null, 
				obj.name(), 
				obj.email(), 
				obj.cpf(), 
				obj.birthDate(), 
				obj.phone()
		);
		return PassengerResponse.fromEntity(passengerRepository.save(passenger));
	}
	
	@Transactional
	public PassengerResponse update(UUID id, PassengerUpdateRequest obj) {
		Passenger passenger = getPassengerOrThrow(id);
		
		passengerRepository.findByCpf(obj.cpf()).ifPresent(existingPassenger -> {
			if(!existingPassenger.getId().equals(id)) {
				throw new BusinessException("CPF already registered");
			}
		});
		passengerRepository.findByEmail(obj.email()).ifPresent(existingPassenger -> {
			if(!existingPassenger.getId().equals(id)) {
				throw new BusinessException("Email already registered");
			}
		});
		
		passenger.setName(obj.name());
		passenger.setEmail(obj.email());
		passenger.setCpf(obj.cpf());
		passenger.setBirthDate(obj.birthDate());
		passenger.setPhone(obj.phone());
		
		return PassengerResponse.fromEntity(passengerRepository.save(passenger));
	}
	
	@Transactional
	public void delete(UUID id) {
		if(!passengerRepository.existsById(id)) {
			throw new ResourceNotFoundException("Passenger not found with id " + id);
		}
		passengerRepository.deleteById(id);
	}
	
	private Passenger getPassengerOrThrow(UUID id) {
		return passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id " + id));
	}
}
