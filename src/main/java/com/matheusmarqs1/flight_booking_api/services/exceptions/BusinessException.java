package com.matheusmarqs1.flight_booking_api.services.exceptions;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message) {
		super(message);
	}

}
