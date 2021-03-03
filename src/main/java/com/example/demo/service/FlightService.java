package com.example.demo.service;


import java.sql.Date;
import java.util.List;

import com.example.demo.common.Common.PreferredClass;
import com.example.demo.entity.Flight;

public interface FlightService {
	
	public Flight save(Flight f);
	
	public Flight getFlightById(int id);
	
	public List<Flight> getFlights();
	
	public void deleteFlightById(int id);
	
	public Flight getFlightBySourceAndDestinationAndDate(String source, String destination, Date d);

	public Flight searchFlight(String source, String destination, Date date);

	public Boolean checkSeatAvailability(Flight flight, PreferredClass preferredClass);

	public void updateSeatAvaialability(Flight flight, PreferredClass preferredClass);
	
}
