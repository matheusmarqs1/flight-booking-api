package com.matheusmarqs1.flight_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
