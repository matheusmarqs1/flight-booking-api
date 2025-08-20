package com.matheusmarqs1.flight_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusmarqs1.flight_booking_api.entities.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
