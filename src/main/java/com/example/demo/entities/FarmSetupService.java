package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FarmSetupService {
	public static int valueState=105323;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private LocalDateTime dateTime;
	int price=105323;
	private boolean isDelevered;
	private int value=1045323;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public FarmSetupService() {
		super();
		this.id = 0;
		this.dateTime = LocalDateTime.now();
		this.isDelevered = false;
	}
	public FarmSetupService(Integer id, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.isDelevered = false;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public boolean isDelevered() {
		return isDelevered;
	}
	public void setDelevered(boolean isDelevered) {
		this.isDelevered = isDelevered;
	}
}
