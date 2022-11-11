package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AgricultureProduct;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.InvalidKeyException;
import com.example.demo.repositories.CustomerDAO;
import com.example.demo.services.CustomerService;

@RestController
public class AgricultureProductController {
	@Autowired
	CustomerService cus;
	@Autowired
	CustomerDAO cud;
	
	@GetMapping("/agriculture_products/all")
	List<AgricultureProduct> fun1() {
		return AgricultureProduct.getAvailableProducts();
	}  //dddf
	
	
	@PostMapping(value="/buy/agriculture_product")
	String fun2(@RequestParam("key") String uuid,@RequestParam("agriculture product id") int id){
		Customer c=cus.validate(uuid);
		if(c.getWalletMoney()>=AgricultureProduct.availableProducts.get(id).getPrice()) {
			c.getProducts().getPurchased().add(AgricultureProduct.availableProducts.get(id));
			cud.save(c);
		}else {
			throw new InvalidKeyException("Unsufficiant money in wallet");
		}
		return "purchased succesfully";
	}
	
}
