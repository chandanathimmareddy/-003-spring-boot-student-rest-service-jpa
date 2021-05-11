package com.example.student.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PUBLIC)

public class StudentUtils {

	private StudentUtils()
	{

	}
	
  public static void validateAddress(String zipcode)
  {
	  String regex= "^[0-9]{5}(?:-[0-9]{4})?$";
	  
	  Pattern pattern=Pattern.compile(regex);
	  
	  Matcher matcher=pattern.matcher(zipcode);
	  
	  if(!matcher.matches())
	  {
		  throw new IllegalArgumentException("invalid zipcode");
	  }
	  
  }
	
}
