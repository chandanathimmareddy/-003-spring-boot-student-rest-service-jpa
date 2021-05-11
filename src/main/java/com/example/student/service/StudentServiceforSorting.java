package com.example.student.service;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.example.student.model.Student;

@Service
public class StudentServiceforSorting implements Comparator<Student> {
	
	public int compare(Student s1, Student s2)
	{
		
		return s1.getStudentname().compareTo(s2.getStudentname());
			
	}
	


}
