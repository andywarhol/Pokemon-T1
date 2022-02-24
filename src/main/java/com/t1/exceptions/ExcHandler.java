package com.t1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class ExcHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDetails> psqlExc(RuntimeException e, WebRequest req){
		ErrorDetails error = new ErrorDetails("Usuario o Pokemon ya existente", 900 );
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorDetails> nullPoint(NullPointerException e, WebRequest req){
		ErrorDetails error = new ErrorDetails("Falta un campo por llenar", 1000);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
