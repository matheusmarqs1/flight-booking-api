package com.matheusmarqs1.flight_booking_api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_airport")
public class Airport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String code;
	private String city;
	private String country;
	
	@JsonIgnore
	@OneToMany(mappedBy = "departureAirport")
	Set<Flight> departingFlights = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "arrivalAirport")
	Set<Flight> arrivingFlights = new HashSet<>();
	
	public Airport() {
	}

	public Airport(Long id, String name, String code, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.city = city;
		this.country = country;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Flight> getDepartingFlights() {
		return departingFlights;
	}

	public Set<Flight> getArrivingFlights() {
		return arrivingFlights;
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
		Airport other = (Airport) obj;
		return Objects.equals(id, other.id);
	}
	
}
