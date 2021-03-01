package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Fare;

public interface FareRepository extends JpaRepository<Fare, Integer>{
	public Fare findBySourceAndDestination(String source, String destination);
}
