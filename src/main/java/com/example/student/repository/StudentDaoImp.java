package com.example.student.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.model.Student;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Repository
@FieldDefaults(level=AccessLevel.PRIVATE)
public class StudentDaoImp implements StudentDao {
	
    EntityManager entityManager ;
    
    @Autowired
	public StudentDaoImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

    @Override
    public List<Student>listofStudents()
	{
		
	List<Student>students=entityManager.createQuery("from Student").getResultList();
     return students;
	}

	@Override
	
	public Student getStudentById(String id) {
		
		Student student=entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public Student saveorupdateStudent(Student student) {
    	Student student1=entityManager.merge(student);
    	student.setId(student1.getId());
        return (student1);

		
	}
	
	@Override
	public void deleteStudentbyId(String id) {
		
		  Student student = entityManager.find(Student.class, id);

		
	       entityManager.remove(student);
		
		
			
	}	

}
