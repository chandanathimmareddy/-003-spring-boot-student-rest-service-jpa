package com.example.student.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ServiceMessage {
	
	String code;
	String type;
	String description;
	public ServiceMessage() {
		super();
	}
	public ServiceMessage(String code, String type, String description) {
		super();
		this.code = code;
		this.type = type;
		this.description = description;
	}

}
