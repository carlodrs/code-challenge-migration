package com.example.dummyjson.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(WebClientResponseException.NotFound.class)
	public ResponseEntity<Object> handle404Exception( WebClientResponseException.NotFound ex) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(WebClientResponseException.BadRequest.class)
	public ResponseEntity<Object> handle400Exception( WebClientResponseException.BadRequest ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	public ResponseEntity<Object> handleTypeMismatchException( MethodArgumentTypeMismatchException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
}
