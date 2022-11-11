package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AgricultureProduct;
import com.example.demo.entities.AutomaticFarmService;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.InvalidKeyException;
import com.example.demo.repositories.CustomerDAO;
import com.example.demo.services.CustomerService;

@RestController
public class AutomaticFarmSetupController {
	@Autowired
	CustomerService cus;
	@Autowired
	CustomerDAO cud;
	
	@PostMapping(value="/buy/AutomaticFarmSetup_product")
	String fun2(@RequestParam("key") String uuid,@RequestParam("agriculture product id") int id){
		Customer c=cus.validate(uuid);
		if(c.getWalletMoney()>=AutomaticFarmService.valueState) {
			c.getProducts().getAuto().add(new AutomaticFarmService());
			cud.save(c);
		}else {
			throw new InvalidKeyException("Unsufficiant money in wallet");
		}
		return "purchased succesfully";
	}
}
