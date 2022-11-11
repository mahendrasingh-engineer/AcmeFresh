package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AutomaticFarmService;
import com.example.demo.entities.Customer;
import com.example.demo.entities.FarmSetupService;
import com.example.demo.exceptions.InvalidKeyException;
import com.example.demo.repositories.CustomerDAO;
import com.example.demo.services.CustomerService;

@RestController
public class FarmSetupController {
	@Autowired
	CustomerService cus;
	@Autowired
	CustomerDAO cud;
	
	@GetMapping(value = "/farmesetup/details")
	FarmSetupService fun1() {
		return new FarmSetupService();
	}
	
	@PostMapping(value="/buy/farmesetup")
	String fun2(@RequestParam("key") String uuid){
		Customer c=cus.validate(uuid);
		if(c.getWalletMoney()>=FarmSetupService.valueState) {
			c.getProducts().getSetup().add(new FarmSetupService());
			cud.save(c);
		}else {
			throw new InvalidKeyException("Unsufficiant money in wallet");
		}
		return "purchased succesfully";
	}
}
