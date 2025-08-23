package com.matheusmarqs1.flight_booking_api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, UUID> {
	Optional<Passenger> findByCpf(String cpf);
	Optional<Passenger> findByEmail(String email);
}
