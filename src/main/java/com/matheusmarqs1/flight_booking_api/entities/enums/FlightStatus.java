package com.matheusmarqs1.flight_booking_api.entities.enums;

public enum FlightStatus {
	
	SCHEDULED(1),
	DELAYED(2),
	CANCELED(3),
	BOARDING(4),
	DEPARTED(5),
	LANDED(6);
	
	private int code;
	
	private FlightStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static FlightStatus valueOf(int code) {
		for(FlightStatus status : FlightStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid FlightStatus code");
	}
}
