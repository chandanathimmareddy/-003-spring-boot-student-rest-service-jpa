package com.example.student.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Table(name="address")
public class Address implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
	   
	@Column(name="street")
    String street;
	
	@Column(name="city")
     String city;
	
	@Column(name="country")
	 String country;
	
	
	@Column(name="zipcode")
    @NotNull(message="zipcode should not br null")
	String zipcode;
	
	
	
	public Address(String street, String city, String country, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}

	public Address() {
		super();
	}
	
	
}
