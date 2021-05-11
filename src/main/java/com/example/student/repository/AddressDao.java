package com.example.student.repository;

import java.util.List;

import com.example.student.model.Address;

public interface AddressDao {
  public List<Address>listofAddress();
	
	public Address getAddressById(String id);
	
	public Address saveorupdateAddress(Address Address);
	
    public void deleteAddressbyId(String id);
	
	

}
