package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HydroponicProduct {
	public static List<HydroponicProduct> availableProducts=new ArrayList<>();
	
	static {
		availableProducts.add(new HydroponicProduct(0, "Cassava", 50.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(1, "Cassava", 50.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(2, "maize", 55.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(3, "plantains", 450.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(4, "potatoes", 650.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(5, "rice", 111.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(6, "sorghum", 350.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(7, "soybeans", 980.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(8, "sweet potatoes", 120.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(9, "wheat", 220.00, "1 vquantum"));
		availableProducts.add(new HydroponicProduct(10, "Bell peppers", 330.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(11, "Broccoli", 40.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(12, "Carrots", 450.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(13, "Cauliflower", 450.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(14, "Cucumber", 430.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(15, "Garlic", 430.00, "1 quantum"));
		availableProducts.add(new HydroponicProduct(16, "Kale", 660.00, "1 quantum"));
	}
	@Id
	private Integer id;
	private String name;
	private Double price;
	private String description;
	public HydroponicProduct(Integer id, String name, Double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public HydroponicProduct() {
		super();
	}
	public static List<HydroponicProduct> getAvailableProducts() {
		return availableProducts;
	}
	public static void setAvailableProducts(List<HydroponicProduct> availableProducts) {
		HydroponicProduct.availableProducts = availableProducts;
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
