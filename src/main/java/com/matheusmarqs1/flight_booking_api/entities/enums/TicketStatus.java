package com.matheusmarqs1.flight_booking_api.entities.enums;

public enum TicketStatus {
	
	ISSUED(1),
	USED(2),
	CANCELED(3);
	
	private int code;
	
	private TicketStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TicketStatus valueOf(int code) {
		for(TicketStatus status : TicketStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid TicketStatus code");
	}
}
