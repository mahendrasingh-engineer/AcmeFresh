package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HydroponicProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private boolean isDelevered;
	public HydroponicProduct() {
		super();
	}
	public HydroponicProduct(Integer id, String name, boolean isDelevered) {
		super();
		this.id = id;
		this.name = name;
		this.isDelevered = isDelevered;
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
	public boolean isDelevered() {
		return isDelevered;
	}
	public void setDelevered(boolean isDelevered) {
		this.isDelevered = isDelevered;
	}
}
