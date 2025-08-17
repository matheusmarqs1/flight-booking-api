package com.matheusmarqs1.flight_booking_api.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;
import com.matheusmarqs1.flight_booking_api.repositories.PassengerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		
		Passenger p1 = new Passenger(null, "Matheus Teles", "matheust@example.com", "12345678909", LocalDate.parse("10/10/1987", FORMATTER), "988888888");
		Passenger p2 = new Passenger(null, "Thiago Diogo", "thiagodiogo@example.com", "12345678908", LocalDate.parse("10/04/1986", FORMATTER), "977777777");
		
		passengerRepository.saveAll(Arrays.asList(p1, p2));
	}
	
	
}
