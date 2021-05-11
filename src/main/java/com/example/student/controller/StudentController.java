package com.example.student.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.constants.MessageConstant;
import com.example.student.model.InvalidException;
import com.example.student.model.ServiceMessage;
import com.example.student.model.ServiceResponse;
import com.example.student.model.Student;
import com.example.student.model.StudentNotFoundException;
import com.example.student.model.StudentServiceResponse;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceforSorting;
import com.example.student.utils.StudentUtils;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/student")

public class StudentController {
	
List<Student>studentslist=new ArrayList<Student>();

Logger logger = (Logger) LoggerFactory.getLogger(StudentController.class);

        @Autowired
        StudentServiceResponse	serviceResponse;
        
        @Autowired
        StudentServiceforSorting studentService1;
        
        @Autowired
        StudentService studentService;
        
        
        
				@Autowired
				public StudentController(StudentServiceResponse serviceResponse,StudentServiceforSorting studentService1,StudentService studentService) {
					super();
					this.serviceResponse = serviceResponse;
					this.studentService1 =studentService1;
					this.studentService=studentService;

				}
				
				
			    @GetMapping("/names")
				public ResponseEntity<StudentServiceResponse>studentlist()
			  {
                    logger.info("list of students with address");
                    
					ServiceMessage serviceMessage = new ServiceMessage();
					serviceMessage.setCode(MessageConstant.SUCCESS_RESPONSE_CODE);
					serviceMessage.setDescription(MessageConstant.SUCCESS_RESPONSE_DESCRIPTION);
					serviceMessage.setType(MessageConstant.SUCCESS_RESPONSE_TYPE);
					Collections.sort(studentslist, studentService1);
					serviceResponse.setServiceMessage(serviceMessage);
				    serviceResponse.setStudents(studentService.listofStudents());
					return new ResponseEntity<StudentServiceResponse>(serviceResponse, HttpStatus.OK);
					
				   
				
			}
			    @GetMapping("/names/{id}")
				public ResponseEntity<StudentServiceResponse> getStudentbyId(@PathVariable String id)
				{   
			    	logger.info("get studentbyid");
			    	if(studentService.getStudentById(id)==null)
			    	{
			    	 throw new StudentNotFoundException("student not found at id:"+id);
			    	}
					ServiceMessage serviceMessage = new ServiceMessage();
 					serviceMessage.setCode(MessageConstant.SUCCESS_RESPONSE_CODE);
					serviceMessage.setDescription(MessageConstant.SUCCESS_RESPONSE_DESCRIPTION);
					serviceMessage.setType(MessageConstant.SUCCESS_RESPONSE_TYPE);
					serviceResponse.setServiceMessage(serviceMessage);
					serviceResponse.setStudent(studentService.getStudentById(id));
					return new ResponseEntity<StudentServiceResponse>(serviceResponse,  HttpStatus.OK);
					
				}
			    
			    @PostMapping(path ="/names", consumes = "application/json", produces = "application/json")
				public ResponseEntity<StudentServiceResponse> saveStudent(@Valid@RequestBody Student students,BindingResult theBindingResult)
				{   
                    StudentUtils.validateAddress(students.getAddress().getZipcode());
			    	if(theBindingResult.hasErrors())
				{   
			    	logger.error("Error");
                     throw new InvalidException("Invalid Request");
				}else
				{    
                    logger.info("save the student");
					ServiceMessage serviceMessage = new ServiceMessage(MessageConstant.CREATED_RESPONSE_CODE,MessageConstant.CREATED_RESPONSE_DESCRIPTION,MessageConstant.CREATED_RESPONSE_TYPE);
					serviceResponse.setServiceMessage(serviceMessage);
				    serviceResponse.setStudent(studentService.saveorupdateStudent(students));
					return new ResponseEntity<StudentServiceResponse>(serviceResponse,HttpStatus.CREATED);
				}
		}
			    
			    @PutMapping(path ="/names/{id}", consumes = "application/json", produces = "application/json")
				public ResponseEntity<StudentServiceResponse> updateStudent(@PathVariable String id ,@Valid@RequestBody Student student, BindingResult theBindingResult)
				{   
		    	    Student student1=studentService.getStudentById(id);
		    	    if(studentService.getStudentById(id)==null)
			    	{
			    	 throw new StudentNotFoundException("student not found at id:"+id);
			    	}
		    	    student1.setStudentname(student.getStudentname());
			        student1.setAddress(student.getAddress());			    	
			    	if(theBindingResult.hasErrors())
					{   
				    	logger.error("Error");

	                     throw new InvalidException("Invalid Request");

					}else
					{
						logger.info("update studentinfo");
					ServiceMessage serviceMessage = new ServiceMessage();
                    serviceMessage.setCode(MessageConstant.SUCCESS_RESPONSE_CODE);
					serviceMessage.setDescription(MessageConstant.SUCCESS_RESPONSE_DESCRIPTION);
					serviceMessage.setType(MessageConstant.SUCCESS_RESPONSE_TYPE);
					serviceResponse.setServiceMessage(serviceMessage);
				    serviceResponse.setStudent(studentService.saveorupdateStudent(student1));
					return new ResponseEntity<StudentServiceResponse>(serviceResponse,HttpStatus.OK);
		}
				}
			    
			    @DeleteMapping(path ="/names/{id}")
				public ResponseEntity<ServiceResponse> deletStudentbyId( @PathVariable String id)
				{  
			    	logger.info("delete student by id");
			    	if(studentService.getStudentById(id)==null)
			    	{
			    	 throw new StudentNotFoundException("student not found at id:"+id);
			    	}
			    	studentService.deleteStudentbyId(id);
					ServiceMessage serviceMessage = new ServiceMessage();
					serviceMessage.setCode(MessageConstant.SUCCESS_RESPONSE_CODE);
					serviceMessage.setDescription(MessageConstant.SUCCESS_RESPONSE_DESCRIPTION);
					serviceMessage.setType(MessageConstant.SUCCESS_RESPONSE_TYPE);
					serviceResponse.setServiceMessage(serviceMessage);
			        return new ResponseEntity<ServiceResponse>(serviceResponse,HttpStatus.OK);
		}
			   
			    


}
