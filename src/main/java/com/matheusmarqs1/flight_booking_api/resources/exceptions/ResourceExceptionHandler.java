package com.matheusmarqs1.flight_booking_api.resources.exceptions;

import java.time.Instant;
import java.time.format.DateTimeParseException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheusmarqs1.flight_booking_api.services.exceptions.BusinessException;
import com.matheusmarqs1.flight_booking_api.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				Instant.now(), 
				status.value(), 
				error, 
				"Cannot delete passenger. Related records exist", 
				request.getRequestURI()
		);
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<StandardError> handleBusinessException(BusinessException e, HttpServletRequest request){
		String error = "Business rule violation";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<StandardError> handleDateTimeParseException(DateTimeParseException e, HttpServletRequest request){
		String error = "Invalid date format";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				Instant.now(), 
				status.value(), 
				error, 
				"Date must be in 'yyyy-MM-dd' format (ex: 2024-12-25)", 
				request.getRequestURI()
		);
		return ResponseEntity.status(status).body(err);
	}
	
	
	
}
