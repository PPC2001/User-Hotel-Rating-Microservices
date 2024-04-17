package com.microservices.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.userservice.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Whenever anywhere in this project if you get ResourceNotFoundException then
	// below
	// method will get call
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
		ApiResponse response = ApiResponse.builder().message(exception.getMessage()).success(true)
				.status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}

}
