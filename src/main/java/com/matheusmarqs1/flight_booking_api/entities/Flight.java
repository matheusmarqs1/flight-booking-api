package com.matheusmarqs1.flight_booking_api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.matheusmarqs1.flight_booking_api.entities.enums.FlightStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_flight")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String flightNumber;
	private Instant departureTime;
	private Instant arrivalTime;
	private Integer flightStatus;
	
	@ManyToOne
	@JoinColumn(name = "airline_id")
	private Airline airline;
	
	@ManyToOne
	@JoinColumn(name = "departure_airport_id")
	private Airport departureAirport;
	
	@ManyToOne
	@JoinColumn(name = "arrival_airport_id")
	private Airport arrivalAirport;
	
	public Flight() {
	}

	public Flight(Long id, String flightNumber, Instant departureTime, Instant arrivalTime, FlightStatus flightStatus, Airline airline, Airport departureAirport, Airport arrivalAirport) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		setFlightStatus(flightStatus);
		this.airline = airline;
		this.setDepartureAirport(departureAirport);
		this.setArrivalAirport(arrivalAirport);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Instant getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Instant departureTime) {
		this.departureTime = departureTime;
	}

	public Instant getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Instant arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public FlightStatus getFlightStatus() {
		return FlightStatus.valueOf(flightStatus);
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		if(flightStatus != null) {
			this.flightStatus = flightStatus.getCode();
		}
	}
	
	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(id, other.id);
	}

}
