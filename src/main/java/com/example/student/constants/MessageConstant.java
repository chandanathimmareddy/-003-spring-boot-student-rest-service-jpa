package com.example.student.constants;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PUBLIC)
public final class MessageConstant {
	
	public static String SUCCESS_RESPONSE_CODE="200";
	public static String SUCCESS_RESPONSE_TYPE="OK";
	public static String SUCCESS_RESPONSE_DESCRIPTION="Request completed successfully";
	public static String CREATED_RESPONSE_CODE="201";
	public static String CREATED_RESPONSE_TYPE="CREATED";
	public static String CREATED_RESPONSE_DESCRIPTION="Request created successfully";
	public static String BAD_REQUEST_RESPONSE_CODE="400";
	public static String BAD_REQUEST_RESPONSE_TYPE="BAD REQUEST";
	public static String BAD_REQUEST_RESPONSE_DESCRIPTION="Request failed";
	 }
