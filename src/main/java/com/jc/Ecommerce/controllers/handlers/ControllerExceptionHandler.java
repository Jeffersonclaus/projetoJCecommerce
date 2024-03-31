package com.jc.Ecommerce.controllers.handlers;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jc.Ecommerce.dto.CustomError;
import com.jc.Ecommerce.services.exeption.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	
	
	public ResponseEntity<CustomError> resourceNotFoundExpetion(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError err = new CustomError(Instant.now(), status.value(),e.getMessage(),request.getRequestURI());
				return ResponseEntity.status(status).body(err);
}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	
	
	public ResponseEntity<CustomError> data(DataIntegrityViolationException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError err = new CustomError(Instant.now(), status.value(),e.getMessage(),request.getRequestURI());
				return ResponseEntity.status(status).body(err);
}
	
	
	
}