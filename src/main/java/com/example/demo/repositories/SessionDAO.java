package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Session;

public interface SessionDAO extends JpaRepository<Session, String>{

}
