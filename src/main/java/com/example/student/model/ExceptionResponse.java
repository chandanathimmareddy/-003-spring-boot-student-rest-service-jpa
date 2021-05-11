package com.example.student.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ExceptionResponse {
	
	long timestamp;
	int status;
	String message;

	public ExceptionResponse() {
		super();
	}
	public ExceptionResponse(long timestamp, int status,String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}
	
	

}
