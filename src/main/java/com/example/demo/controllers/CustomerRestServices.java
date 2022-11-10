package com.example.demo.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CuctomerRegDto;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Products;
import com.example.demo.entities.Session;
import com.example.demo.exceptions.AlreadyExistException;
import com.example.demo.exceptions.CustomerNotFound;
import com.example.demo.repositories.CustomerDAO;
import com.example.demo.repositories.SessionDAO;


import net.bytebuddy.utility.RandomString;

@RestController
public class CustomerRestServices {
	@Autowired
	CustomerDAO cuDao;
	@Autowired
	SessionDAO ssd;
	
	@PostMapping(value="/customer/register")
	String fun(@Valid  @RequestBody CuctomerRegDto ddt) throws AlreadyExistException {
		Customer c=null;
		
		try {
			 c=cuDao.findByPhone(ddt.phone);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(c!=null) {
			throw new AlreadyExistException();
		}
		c=new Customer(ddt.name, ddt.phone, ddt.password, 0.0,new Products());
		c.setPhone(ddt.phone);
		cuDao.save(c);
		return "done";
	}
	
	@PostMapping(value="/customer/login")
	String fun2(@Valid @RequestBody CuctomerRegDto ddt) {
		Customer c=null;
		try {
			 c=cuDao.findByPhone(ddt.phone);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(c==null) {
			throw new CustomerNotFound();
		}
		
		if(c.getPassword().equals(ddt.password)) {
			try {
				ssd.save(new Session(ddt.phone,ddt.phone+RandomStringUtils.random(10)));
			} catch (Exception e) {
				return "errorr";
			}
			
		}
		
		
		return "done";
	}
	
	
	
}
