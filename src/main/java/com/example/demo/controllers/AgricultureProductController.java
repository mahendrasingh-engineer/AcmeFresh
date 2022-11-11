package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AgricultureProduct;

@RestController
public class AgricultureProductController {
	@GetMapping("/agriculture_products/all")
	List<AgricultureProduct> fun1() {
		return AgricultureProduct.getAvailableProducts();
	}
	
	
}
