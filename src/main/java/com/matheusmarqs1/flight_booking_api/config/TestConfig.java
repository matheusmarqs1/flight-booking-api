package com.matheusmarqs1.flight_booking_api.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;
import com.matheusmarqs1.flight_booking_api.entities.Reservation;
import com.matheusmarqs1.flight_booking_api.repositories.PassengerRepository;
import com.matheusmarqs1.flight_booking_api.repositories.ReservationRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		
		Passenger p1 = new Passenger(null, "Matheus Teles", "matheust@example.com", "12345678909", LocalDate.parse("10/10/1987", FORMATTER), "988888888");
		Passenger p2 = new Passenger(null, "Thiago Diogo", "thiagodiogo@example.com", "12345678908", LocalDate.parse("10/04/1986", FORMATTER), "977777777");
		
		passengerRepository.saveAll(Arrays.asList(p1, p2));
		
		Reservation r1 = new Reservation(null, "PNR0001", Instant.parse("2025-07-11T19:53:07Z"), p1);
		Reservation r2 = new Reservation(null, "PNR0002", Instant.parse("2025-08-18T11:30:00Z"), p2);
		Reservation r3 = new Reservation(null, "PNR0003", Instant.parse("2025-08-18T10:00:00Z"), p1);
		
		reservationRepository.saveAll(Arrays.asList(r1, r2, r3));
	}
	
	
}
