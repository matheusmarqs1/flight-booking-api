package com.matheusmarqs1.flight_booking_api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	private String phone;
	
	public Passenger() {
	}

	public Passenger(Long id, String name, String email, String cpf, LocalDate birthDate, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		Passenger other = (Passenger) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
