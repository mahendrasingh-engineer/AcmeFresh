package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Products {
	@Id 
	@GeneratedValue(strategy  = GenerationType.AUTO)
	int id;
	@OneToMany(cascade = CascadeType.ALL)
	private List<FarmSetupService> setup;
	@OneToMany(cascade = CascadeType.ALL)
	private List<AutomaticFarmService> auto;
	@OneToMany(cascade = CascadeType.ALL)
	private List<HydroponicProduct> hydroponicProducts;
	@OneToMany(cascade = CascadeType.ALL)
	private List<AgricultureProduct> purchased;
	
	
	
	public Products() {
		super();
		this.auto=new ArrayList<AutomaticFarmService>();
		this.hydroponicProducts=new ArrayList<HydroponicProduct>();
		this.setup=new ArrayList<FarmSetupService>();
		this.purchased=new ArrayList<AgricultureProduct>();
	}
	public List<FarmSetupService> getSetup() {
		return setup;
	}
	public void setSetup(List<FarmSetupService> setup) {
		this.setup = setup;
	}
	public List<AutomaticFarmService> getAuto() {
		return auto;
	}
	public void setAuto(List<AutomaticFarmService> auto) {
		this.auto = auto;
	}
	public List<HydroponicProduct> getHydroponicProducts() {
		return hydroponicProducts;
	}
	public void setHydroponicProducts(List<HydroponicProduct> hydroponicProducts) {
		this.hydroponicProducts = hydroponicProducts;
	}
	public List<AgricultureProduct> getPurchased() {
		return purchased;
	}
	public void setPurchased(List<AgricultureProduct> purchased) {
		this.purchased = purchased;
	}
	
}
