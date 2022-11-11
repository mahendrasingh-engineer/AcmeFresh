package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.exceptions.InvalidKeyException;
import com.example.demo.repositories.CustomerDAO;

@Service
public class CustomerService {
	@Autowired
	CustomerDAO cud;
	
	public Customer validate(String uuid) {
		Optional<Customer> oc=cud.findByUuid(uuid);
		if(oc.isEmpty()) {
			throw new InvalidKeyException("Unouthorized access/invalid key");
		}
		return (Customer) oc.get();
	}
}
