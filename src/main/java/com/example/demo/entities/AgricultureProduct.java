package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AgricultureProduct {
	public static List<AgricultureProduct> availableProducts=new ArrayList<>();
	static {
		availableProducts.add(new AgricultureProduct(0, "Cassava", 50.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(1, "Cassava", 50.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(2, "maize", 55.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(3, "plantains", 450.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(4, "potatoes", 650.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(5, "rice", 111.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(6, "sorghum", 350.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(7, "soybeans", 980.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(8, "sweet potatoes", 120.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(9, "wheat", 220.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(10, "Bell peppers", 330.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(11, "Broccoli", 40.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(12, "Carrots", 450.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(13, "Cauliflower", 450.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(14, "Cucumber", 430.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(15, "Garlic", 430.00, "1 Kilogram"));
		availableProducts.add(new AgricultureProduct(16, "Kale", 660.00, "1 Kilogram"));
	}
	/*
	 */
	@Id
	private Integer id;
	private String name;
	private Double price;
	private String description;
	public AgricultureProduct() {
		super();
	}
	public AgricultureProduct(Integer id, String name, Double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public static List<AgricultureProduct> getAvailableProducts() {
		return availableProducts;
	}
	public static void setAvailableProducts(List<AgricultureProduct> availableProducts) {
		AgricultureProduct.availableProducts = availableProducts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
