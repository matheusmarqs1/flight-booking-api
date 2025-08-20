package com.matheusmarqs1.flight_booking_api.entities.enums;

public enum SeatClass {
	
	ECONOMY(1),
	BUSINESS(2),
	FIRST(3);
	
	private int code;
	
	private SeatClass(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static SeatClass valueOf(int code) {
		for(SeatClass status : SeatClass.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid SeatClass code");
	}
}
