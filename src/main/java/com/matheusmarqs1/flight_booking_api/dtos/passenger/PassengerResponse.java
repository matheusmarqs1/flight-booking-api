
package com.matheusmarqs1.flight_booking_api.dtos.passenger;

import java.time.LocalDate;
import java.util.UUID;

import com.matheusmarqs1.flight_booking_api.entities.Passenger;

public record PassengerResponse(
		UUID id,
		String name,
		String email,
		String cpf,
		LocalDate birthDate,
		String phone
	) {
	
		public static PassengerResponse fromEntity(Passenger passenger) {
			return new PassengerResponse(
					passenger.getId(), 
					passenger.getName(), 
					passenger.getEmail(), 
					passenger.getCpf(), 
					passenger.getBirthDate(), 
					passenger.getPhone()
			);
		}
	
	
}
