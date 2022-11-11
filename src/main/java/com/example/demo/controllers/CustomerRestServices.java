package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CuctomerRegDto;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Products;
import com.example.demo.exceptions.AlreadyExistException;
import com.example.demo.exceptions.CustomerNotFound;
import com.example.demo.exceptions.InvalidKeyException;
import com.example.demo.repositories.CustomerDAO;
import com.example.demo.services.CustomerService;

import net.bytebuddy.utility.RandomString;




@RestController
public class CustomerRestServices {
	@Autowired
	CustomerDAO cuDao;
	@Autowired
	CustomerService cse;
	
	
	
	
	@PostMapping(value="/customer/register")
	String fun(@Valid  @RequestBody CuctomerRegDto ddt) throws AlreadyExistException {
		Customer c=null;
		Optional<Customer> oc;
		oc=cuDao.findByPhone(ddt.phone);
		
		if(oc.isPresent()) {
			throw new InvalidKeyException("this mobile number is already exist");
		}
		c=new Customer(ddt.name, ddt.phone, ddt.password, 0.0,new Products());
		c.setPhone(ddt.phone);
		cuDao.save(c);
		return "registration done succesfully";
	}
	
	@PostMapping(value="/customer/login")
	String fun2(@Valid @RequestBody CuctomerRegDto ddt) {
		Customer c=null;
		Optional<Customer> oc;
		oc=cuDao.findByPhone(ddt.phone);
		
		if(oc.isEmpty()) {
			throw new InvalidKeyException("this mobile is number not registered with ay customer");
		}
		c=oc.get();
		String key;
		if(!c.getPassword().equals(ddt.password)) {
			throw new InvalidKeyException("invalid password");
		}
		key=RandomString.make(10)+c.getPhone();
		c.setUuid(key);
		cuDao.save(c);
		return key;
	}
	
	@GetMapping(value="/customer/logout")
	String logout(@RequestParam("key") String key) {
		Customer c=cse.validate(key);
		
		c.setUuid(null);
		return "logged out successfully";
	}
	
	
	@PostMapping(value="/customer/wallet/add_money")
	String addMoney(@RequestParam("key") String key,@RequestParam("money") Double money) {
		
		Customer c=cse.validate(key);
		if(money>0) {
			c.setWalletMoney(money+c.getWalletMoney());
		}
		return "updated ballance in wallet ="+c.getWalletMoney();
	}
	
	@DeleteMapping(value="/customer/delete")
	String delete(@RequestParam("key") String key) {
		Customer c=cse.validate(key);
		cuDao.delete(c);
		return "deleted successfully";
	}
	
}
