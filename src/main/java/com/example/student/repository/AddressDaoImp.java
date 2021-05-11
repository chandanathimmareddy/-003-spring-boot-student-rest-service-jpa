package com.example.student.repository;


	import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.model.Address;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

	@Repository
	@Transactional
	@FieldDefaults(level=AccessLevel.PRIVATE)
	public class AddressDaoImp implements AddressDao{
		
		@Autowired
	    EntityManager entityManager ;
	    
	    @Autowired
		public AddressDaoImp(EntityManager entityManager) {
			super();
			this.entityManager = entityManager;
		}

	    @Override
	    @Transactional
		public List<Address>listofAddress()
		{
			
		List<Address>address=entityManager.createQuery("from Address").getResultList();
	     return address;
		}

		@Override
		@Transactional
		public Address getAddressById(String id) {
			
			Address address=entityManager.find(Address.class, id);
			return address;
		}

		@Override
		@Transactional
		public Address saveorupdateAddress(Address address) {
	    	Address address1=entityManager.merge(address);
	        return (address1);

			
		}
		

		@Override
		@Transactional
		public void deleteAddressbyId(String id) {
			
			Address address=entityManager.find(Address.class, id);
			
			entityManager.remove(address);
			
			
			

			
		}

	}


