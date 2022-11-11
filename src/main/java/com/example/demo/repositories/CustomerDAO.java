package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Customer;

public interface CustomerDAO extends JpaRepository<Customer, String>{

	Optional<Customer> findByPhone(String phone);

	Optional<Customer> findByUuid(String uuid);

	
	
}
