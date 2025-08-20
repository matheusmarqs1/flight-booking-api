package com.matheusmarqs1.flight_booking_api.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusmarqs1.flight_booking_api.entities.Airline;
import com.matheusmarqs1.flight_booking_api.entities.Airport;
import com.matheusmarqs1.flight_booking_api.entities.Flight;
import com.matheusmarqs1.flight_booking_api.entities.Passenger;
import com.matheusmarqs1.flight_booking_api.entities.Reservation;
import com.matheusmarqs1.flight_booking_api.entities.Seat;
import com.matheusmarqs1.flight_booking_api.entities.Ticket;
import com.matheusmarqs1.flight_booking_api.entities.enums.FlightStatus;
import com.matheusmarqs1.flight_booking_api.entities.enums.ReservationStatus;
import com.matheusmarqs1.flight_booking_api.entities.enums.SeatClass;
import com.matheusmarqs1.flight_booking_api.entities.enums.TicketStatus;
import com.matheusmarqs1.flight_booking_api.repositories.AirlineRepository;
import com.matheusmarqs1.flight_booking_api.repositories.AirportRepository;
import com.matheusmarqs1.flight_booking_api.repositories.FlightRepository;
import com.matheusmarqs1.flight_booking_api.repositories.PassengerRepository;
import com.matheusmarqs1.flight_booking_api.repositories.ReservationRepository;
import com.matheusmarqs1.flight_booking_api.repositories.SeatRepository;
import com.matheusmarqs1.flight_booking_api.repositories.TicketRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private AirportRepository airportRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		
		Passenger p1 = new Passenger(null, "Matheus Teles", "matheust@example.com", "12345678909", LocalDate.parse("10/10/1987", FORMATTER), "988888888");
		Passenger p2 = new Passenger(null, "Thiago Diogo", "thiagodiogo@example.com", "12345678908", LocalDate.parse("10/04/1986", FORMATTER), "977777777");
		Passenger p3 = new Passenger(null, "Maria Souza", "mariass@example.com", "12345678907", LocalDate.parse("15/03/1995", FORMATTER), "999999999");
		passengerRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Airline a1 = new Airline(null, "LATAM", "LA");
        Airline a2 = new Airline(null, "GOL Linhas Aéreas", "G3");
        Airline a3 = new Airline(null, "Azul Linhas Aéreas", "AD");
        airlineRepository.saveAll(Arrays.asList(a1, a2, a3));
        
        Airport ap1 = new Airport(null, "Aeroporto Internacional de Guarulhos", "GRU", "São Paulo", "Brasil");
		Airport ap2 = new Airport(null, "Aeroporto Internacional de Brasília", "BSB", "Brasília", "Brasil");
		Airport ap3 = new Airport(null, "Aeroporto Internacional do Galeão", "GIG", "Rio de Janeiro", "Brasil");
		airportRepository.saveAll(Arrays.asList(ap1, ap2, ap3));
		
		Flight f1 = new Flight(null, "LA3302", Instant.parse("2025-08-25T10:00:00Z"), Instant.parse("2025-08-25T13:30:00Z"), FlightStatus.SCHEDULED, a1, ap1, ap2);
        Flight f2 = new Flight(null, "G31575", Instant.parse("2025-08-26T15:00:00Z"), Instant.parse("2025-08-26T18:45:00Z"), FlightStatus.SCHEDULED, a2, ap2, ap3);
        Flight f3 = new Flight(null, "AD4001", Instant.parse("2025-08-27T08:00:00Z"), Instant.parse("2025-08-27T11:20:00Z"), FlightStatus.SCHEDULED, a3, ap3, ap1);
        flightRepository.saveAll(Arrays.asList(f1, f2, f3));
        
		Reservation r1 = new Reservation(null, "PNR0001", Instant.parse("2025-07-11T19:53:07Z"), ReservationStatus.CONFIRMED, p1);
		Reservation r2 = new Reservation(null, "PNR0002", Instant.parse("2025-08-18T11:30:00Z"), ReservationStatus.WAITING_PAYMENT, p2);
		Reservation r3 = new Reservation(null, "PNR0003", Instant.parse("2025-08-18T10:00:00Z"), ReservationStatus.CONFIRMED, p1);
		
		reservationRepository.saveAll(Arrays.asList(r1, r2, r3));
		
		Seat s1 = new Seat(null, "1A", SeatClass.ECONOMY, f1);
		Seat s2 = new Seat(null, "1B", SeatClass.ECONOMY, f1);
		Seat s3 = new Seat(null, "1A", SeatClass.ECONOMY, f2);
		Seat s4 = new Seat(null, "1B", SeatClass.ECONOMY, f2);
		Seat s5 = new Seat(null, "1A", SeatClass.ECONOMY, f3);
		Seat s6 = new Seat(null, "1B", SeatClass.ECONOMY, f3);
		seatRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6));
		
		Ticket t1 = new Ticket(null, 500.0, TicketStatus.USED, p1, r1);
		Ticket t2 = new Ticket(null, 500.0, TicketStatus.USED, p3, r1);
		Ticket t3 = new Ticket(null, 479.85, TicketStatus.ISSUED, p1, r3);
		
		ticketRepository.saveAll(Arrays.asList(t1, t2, t3));
		
		
		
	}
	
	
}
