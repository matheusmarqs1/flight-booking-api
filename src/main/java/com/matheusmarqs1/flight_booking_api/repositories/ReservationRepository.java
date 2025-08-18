package com.matheusmarqs1.flight_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusmarqs1.flight_booking_api.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
