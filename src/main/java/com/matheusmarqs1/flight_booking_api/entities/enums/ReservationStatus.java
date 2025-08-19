package com.matheusmarqs1.flight_booking_api.entities.enums;

public enum ReservationStatus {
	
	WAITING_PAYMENT(1),
	CONFIRMED(2),
	CANCELED(3);
	
	private int code;
	
	private ReservationStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static ReservationStatus valueOf(int code) {
		for(ReservationStatus status : ReservationStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid ReservationStatus code");
	}
}
