package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.HydroponicProduct;

public interface HydroponicProductDTO extends JpaRepository<HydroponicProduct, Integer>{

}
