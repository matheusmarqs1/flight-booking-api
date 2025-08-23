package com.matheusmarqs1.flight_booking_api.dtos.passenger;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PassengerCreateRequest(
		@NotBlank(message = "Name cannot be blank")
		@Size(max = 100, message = "Name must be up to 100 characters")
		String name,
		
		@NotBlank(message = "Email cannot be blank")
		@Size(max = 255, message = "Email must be up to 255 characters")
		@Email(message = "Invalid email format")
		String email,
		
		@NotBlank(message = "CPF cannot be blank")
		@CPF(message = "Invalid CPF format")
		String cpf,
		
		@NotNull(message = "Date of birth cannot be null")
		@Past(message = "Date of birth must be in the past")
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate birthDate,
		
		@NotBlank(message = "Telephone cannot be blank")
		@Pattern(regexp = "^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}[\\s-]?\\d{4}$", message = "Invalid telephone format")
		String phone
		) {

}
