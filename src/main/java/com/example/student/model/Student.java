package com.example.student.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Table(name="student")
public class Student implements Serializable {

	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
   @Column(name="id")
   @GeneratedValue(generator = "UUID")
   @GenericGenerator(
       name = "UUID",
       strategy = "org.hibernate.id.UUIDGenerator")
      String id;
	
    @NotBlank
    @NotNull
    @Size(min=2,message="minimum 2 characters should be there")
    @Column(name="name")
    String studentname;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="addressid")
    Address Address;
    
    

	public Student(String id, String studentname, Address address) {
		super();
		this.id = UUID.randomUUID().toString();
		this.studentname = studentname;
		Address = address;
	}



	public Student() {
		super();
	}
    
    
	
	

}
