package com.matheusmarqs1.flight_booking_api.entities;

import java.io.Serializable;
import java.util.Objects;

import com.matheusmarqs1.flight_booking_api.entities.enums.TicketStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ticket")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double price;
	private Integer ticketStatus;
	
	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;
	
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
	public Ticket() {
	}

	public Ticket(Long id, Double price, TicketStatus ticketStatus, Passenger passenger, Reservation reservation, Flight flight) {
		super();
		this.id = id;
		this.price = price;
		setTicketStatus(ticketStatus);
		this.passenger = passenger;
		this.reservation = reservation;
		this.flight = flight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TicketStatus getTicketStatus() {
		return TicketStatus.valueOf(ticketStatus);
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		if(ticketStatus != null) {
			this.ticketStatus = ticketStatus.getCode();
		}
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
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
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
