package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.exceptions.InvalidKeyException;
import com.example.demo.repositories.CustomerDAO;

import ch.qos.logback.core.util.Duration;

@Service
public class CustomerService {
	@Autowired
	CustomerDAO cud;
	
	public Customer validate(String uuid) {
		Optional<Customer> oc=cud.findByUuid(uuid);
		if(oc.isEmpty()) {
			throw new InvalidKeyException("Unouthorized access/invalid key");
		}
		Customer c=oc.get();
		if(c.getUuid()==null) {
			throw new InvalidKeyException("Unouthorized access/invalid key");
		}
		LocalDate t=LocalDate.now();
		LocalTime lt1=LocalTime.now();
		LocalDateTime t2=c.getLogTime();
		LocalTime lt2=t2.toLocalTime();
		 
		Period per=Period.between(t2.toLocalDate(), t);
		Double hr=(double) (lt2.getHour()-lt1.getHour());
		System.out.println(per.getDays());
		per.getDays();
		if(per.getYears()==0&&per.getMonths()==0&&per.getDays()==0&&hr<4) {
			return c;
		}else {
			throw new InvalidKeyException("session is over login again");
		}
	}
	
}
