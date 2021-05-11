package com.example.student.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ControllerResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse>handleException(StudentNotFoundException ex)
	{
		ExceptionResponse exceptionResponse=new ExceptionResponse(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),ex.getMessage());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse>handleException(InvalidException ex)
	{
		ExceptionResponse exceptionResponse=new ExceptionResponse(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),ex.getMessage());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
