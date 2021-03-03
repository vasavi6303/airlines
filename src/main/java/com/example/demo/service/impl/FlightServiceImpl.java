package com.example.demo.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.Common.PreferredClass;
import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FareService;
import com.example.demo.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private FareService fareService;

	@Override
	public Flight save(Flight f) {
		return flightRepo.save(f);

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

	@Override
	public Flight searchFlight(String source, String destination, Date date) {

		if (fareService.getFareBySourceAndDestination(source, destination) == null)
			return null;
		Flight flight = flightRepo.findBySourceAndDestinationAndDate(source, destination, date);
		if (flight == null) {
			flight = flightRepo.save(new Flight(source, destination, date));
		}
		return flight;
	}

	@Override
	public Boolean checkSeatAvailability(Flight flight, PreferredClass preferredClass) {
		if (preferredClass == PreferredClass.BusinessClass && flight.getAvailableBusinessClassSeats() <= 0) 
				return false;
		else if(flight.getAvailableEconomyClassSeats() <= 0) 
				return false;
		return true;
	}

	@Override
	public void updateSeatAvaialability(Flight flight, PreferredClass preferredClass) {
		if (preferredClass == PreferredClass.BusinessClass)
			flight.setAvailableBusinessClassSeats(flight.getAvailableBusinessClassSeats() - 1);
		else
			flight.setAvailableEconomyClassSeats(flight.getAvailableEconomyClassSeats() - 1);
		flight = flightRepo.save(flight);
		
	}

}
