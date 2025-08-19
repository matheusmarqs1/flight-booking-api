package com.matheusmarqs1.flight_booking_api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.matheusmarqs1.flight_booking_api.entities.enums.FlightStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Flight() {
	}

	public Flight(Long id, String flightNumber, Instant departureTime, Instant arrivalTime, FlightStatus flightStatus) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		setFlightStatus(flightStatus);
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
