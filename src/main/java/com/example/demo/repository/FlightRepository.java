package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	public Flight findBySourceAndDestinationAndDate(String source, String destination, Date d);

}
