package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Passenger;

@Transactional
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{
	
	Passenger findTopByName(String name);

}
