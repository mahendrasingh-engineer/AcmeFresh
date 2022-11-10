package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FarmSetupService {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private LocalDateTime dateTime;
	private boolean isDelevered;
	public FarmSetupService() {
		super();
	}
	public FarmSetupService(Integer id, LocalDateTime dateTime, boolean isDelevered) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.isDelevered = isDelevered;
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
