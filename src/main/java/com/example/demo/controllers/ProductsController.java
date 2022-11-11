package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AgricultureProduct;
import com.example.demo.entities.Customer;
import com.example.demo.entities.HydroponicProduct;
import com.example.demo.exceptions.InvalidKeyException;
import com.example.demo.repositories.CustomerDAO;
import com.example.demo.services.CustomerService;
@RestController
public class ProductsController {
	@Autowired
	CustomerService cus;
	@Autowired
	CustomerDAO cud;
	
	@GetMapping("/Hydroponic_Product/all")
	List<HydroponicProduct> fun1() {
		return HydroponicProduct.getAvailableProducts();
	}
	
	
	@PostMapping(value="/buy/Hydroponic_Product")
	String fun2(@RequestParam("key") String uuid,@RequestParam("agriculture product id") int id){
		Customer c=cus.validate(uuid);
		if(c.getWalletMoney()>=HydroponicProduct.availableProducts.get(id).getPrice()) {
			c.getProducts().getHydroponicProducts().add(HydroponicProduct.availableProducts.get(id));
			cud.save(c);
		}else {
			throw new InvalidKeyException("Unsufficiant money in wallet");
		}
		return "purchased succesfully";
	}
}
