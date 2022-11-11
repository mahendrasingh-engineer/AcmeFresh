package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.FarmSetupService;

@RestController
public class FarmSetupController {
	@GetMapping(value = "/farmesetup/details")
	FarmSetupService fun1() {
		return new FarmSetupService();
	}
}
