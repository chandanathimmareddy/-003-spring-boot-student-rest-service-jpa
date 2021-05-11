package com.example.student.service;

import java.util.List;

import com.example.student.model.Address;


public interface AddressService {
	
public List<Address>listofAddress();
	
	public Address getAddressById(String id);
	
	public Address saveorupdateAddress(Address Address);
	
    public void deleteAddressbyId(String id);
	
	

}
