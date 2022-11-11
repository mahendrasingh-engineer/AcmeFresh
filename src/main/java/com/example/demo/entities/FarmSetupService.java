package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FarmSetupService {
	public static int valueState=1045323;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private LocalDateTime dateTime;
	
	private boolean isDelevered;
	private int value=1045323;
	public FarmSetupService() {
		super();
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
