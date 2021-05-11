package com.example.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Address;
import com.example.student.repository.AddressDao;

@Service
public class AddressServiceImp implements AddressService {

	@Autowired
	AddressDao addressDao;
	
     @Override
     @Transactional
	public List<Address> listofAddress() {
		return addressDao.listofAddress();
	}

	@Override
	@Transactional
	public Address getAddressById(String id) {
		return addressDao.getAddressById(id);
	}

	@Override
	@Transactional
	public Address saveorupdateAddress(Address Address) {
		return addressDao.saveorupdateAddress(Address);
	}

	@Override
	@Transactional
	public void deleteAddressbyId(String id) {
		addressDao.deleteAddressbyId(id);
	}

}
