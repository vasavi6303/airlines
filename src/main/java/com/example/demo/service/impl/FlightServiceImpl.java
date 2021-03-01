package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightRepository flightRepo;

	@Override
	public Boolean save(Flight f) {
		flightRepo.save(f);
		return true;
	}

	@Override
	public Flight getFlightById(int id) {
		return flightRepo.findById(id).orElse(null);
	}

	@Override
	public List<Flight> getFlights() {
		return flightRepo.findAll();
	}

	@Override
	public void deleteFlightById(int id) {
		flightRepo.deleteById(id);
	}

	@Override
	public Flight getFlightBySourceAndDestinationAndDate(String source, String destination, Date d) {
		return flightRepo.findBySourceAndDestinationAndDate(source, destination, d);
	}
	
	
}
