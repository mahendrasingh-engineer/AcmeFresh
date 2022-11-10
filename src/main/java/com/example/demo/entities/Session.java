package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	private String phone;
	private String keys;
	public Session() {
		super();
	}
	public Session(String phone, String keys) {
		super();
		this.phone = phone;
		this.keys = keys;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
}
