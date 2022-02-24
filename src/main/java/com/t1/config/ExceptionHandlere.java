package com.t1.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.t1.exception.NotFoudExeception;
import com.t1.responsedto.ResponseDTO;

@ControllerAdvice
public class ExceptionHandlere  extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			String fieldName= ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			errores.put(fieldName, message);
		});
		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoudExeception.class)
	public ResponseEntity<ResponseDTO<String>> notFoundException(NotFoudExeception notFound){
		ResponseDTO<String> response = new ResponseDTO<String>("the element wasnt found", notFound.getMessage());
		return new ResponseEntity<ResponseDTO<String>>(response, HttpStatus.NOT_FOUND);
	}

}
