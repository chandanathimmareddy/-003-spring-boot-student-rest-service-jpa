package com.example.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentDao;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
    StudentDao studentDao; 
	
	@Override
	@Transactional
	public List<Student> listofStudents() {
		return studentDao.listofStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(String id) {
		return studentDao.getStudentById(id) ;
	}

	@Override
	@Transactional
	public Student saveorupdateStudent(Student student) {
		return studentDao.saveorupdateStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudentbyId(String id) {
		studentDao.deleteStudentbyId(id);
	}
	
	

}
