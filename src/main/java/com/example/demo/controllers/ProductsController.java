package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AgricultureProduct;
import com.example.demo.entities.HydroponicProduct;
@RestController
public class ProductsController {
	@GetMapping("/Hydroponic_Product/all")
	List<HydroponicProduct> fun1() {
		return HydroponicProduct.getAvailableProducts();
	}
}
