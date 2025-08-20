package com.matheusmarqs1.flight_booking_api.entities;

import java.io.Serializable;
import java.util.Objects;

import com.matheusmarqs1.flight_booking_api.entities.enums.SeatClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_seat")
public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String seatNumber;
	private Integer seatClass;
	
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
	public Seat() {
	}

	public Seat(Long id, String seatNumber, SeatClass seatClass, Flight flight) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		setSeatClass(seatClass);
		this.flight = flight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatClass getSeatClass() {
		return SeatClass.valueOf(seatClass);
	}

	public void setSeatClass(SeatClass seatClass) {
		if(seatClass != null) {
			this.seatClass = seatClass.getCode();
		}
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
		Seat other = (Seat) obj;
		return Objects.equals(id, other.id);
	}
}
