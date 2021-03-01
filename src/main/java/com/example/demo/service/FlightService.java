package com.example.demo.service;


import java.util.Date;
import java.util.List;

import com.example.demo.entity.Flight;

public interface FlightService {
	
	public Boolean save(Flight f);
	
	public Flight getFlightById(int id);
	
	public List<Flight> getFlights();
	
	public void deleteFlightById(int id);
	
	public Flight getFlightBySourceAndDestinationAndDate(String source, String destination, Date d);
	
}
