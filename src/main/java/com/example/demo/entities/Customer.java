package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	private String phone;
	private String name;
	
	private String password;
	private Double walletMoney;
	@OneToOne(cascade = CascadeType.ALL)
	private Products products;
	private String uuid=null;
	private LocalDateTime logTime;
	public LocalDateTime getLogTime() {
		return logTime;
	}
	public void setLogTime(LocalDateTime logTime) {
		this.logTime = logTime;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String key) {
		this.uuid = key;
	}
	public Customer() {
		super();
	}
	public Customer( String name, String phone, String password, Double walletMoney, Products products) {
		super();
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.walletMoney = walletMoney;
		this.products = products;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public synchronized Double getWalletMoney() {
		return walletMoney;
	}
	public synchronized void setWalletMoney(Double walletMoney) {
		this.walletMoney = walletMoney;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	
}
