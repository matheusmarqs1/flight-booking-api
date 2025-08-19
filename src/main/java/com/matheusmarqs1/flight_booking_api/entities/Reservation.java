package com.matheusmarqs1.flight_booking_api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.matheusmarqs1.flight_booking_api.entities.enums.ReservationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reservation")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reservationNumber;
	private Instant bookingTime;
	
	private Integer reservationStatus;
	
	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;
	
	public Reservation() {
	}

	public Reservation(Long id, String reservationNumber, Instant bookingTime, ReservationStatus reservationStatus, Passenger passenger) {
		super();
		this.id = id;
		this.reservationNumber = reservationNumber;
		this.bookingTime = bookingTime;
		setReservationStatus(reservationStatus);
		this.passenger = passenger;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Instant getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Instant bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	public ReservationStatus getReservationStatus() {
		return ReservationStatus.valueOf(reservationStatus);
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		if(reservationStatus != null) {
			this.reservationStatus = reservationStatus.getCode();
		}
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}	
}
