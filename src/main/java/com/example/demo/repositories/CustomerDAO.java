package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	Customer findByPhone(String phone);
}
