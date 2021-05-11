package com.example.student.repository;

import java.util.List;

import com.example.student.model.Student;

public interface StudentDao {
	
	public List<Student>listofStudents();
	
	public Student getStudentById(String id);
	
	public Student saveorupdateStudent(Student student);
	

    public void  deleteStudentbyId(String id);
	
	
}
