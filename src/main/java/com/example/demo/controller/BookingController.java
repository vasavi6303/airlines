package com.example.demo.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Common.PreferredClass;
import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Fare;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Passenger;
import com.example.demo.service.BookingService;
import com.example.demo.service.FareService;
import com.example.demo.service.FlightService;
import com.example.demo.service.PassengerService;

@RestController
public class BookingController {

	@Autowired
	FlightService flightService;

	@Autowired
	PassengerService passengerService;

	@Autowired
	FareService fareService;

	@Autowired
	BookingService bookingService;

	@PostMapping("/bookTicket")
	public Map<String, Object> bookTicket(@RequestBody BookingDto bookingDto) throws ParseException {
		Map<String, Object> map = new HashMap<>();
		
		Passenger passenger = bookingDto.getPassenger();
		String source = bookingDto.getSource();
		String destination = bookingDto.getDestination();
		Date date = bookingDto.getDate();
		PreferredClass preferredClass = bookingDto.getPreferredClass();

		Flight flight = flightService.searchFlight(source, destination, date);
		if (flight == null) {
			map.put("Ërror", "No flight found for the selected cities");
			return map;
		}

		Boolean isSeatAvailable = flightService.checkSeatAvailability(flight, preferredClass);
		if (!isSeatAvailable) {
			map.put("Sorry!", "No "+ preferredClass + " seats available");
			return map;
		}
		
		Fare fare = fareService.getFareBySourceAndDestination(source, destination);

		Booking booking = bookingService.confirmBooking(passenger,flight, date, preferredClass, fare);
		
		map.put("Booking id", booking.getId());
		map.put("Name", passenger.getName());
		map.put("Age", passenger.getAge());
		map.put("Gender", passenger.getGender());
		map.put("source", source);
		map.put("destination", destination);
		map.put("Preferred Class", preferredClass);
		map.put("fare", booking.getFare());
		
		return map;
	}
	
	@GetMapping("/getTicket")
	public String getTicket(@RequestParam("id") int id) {
		Booking booking = bookingService.getBookingById(id);
		if(booking == null)
			return "<h1>Welcome to ABC Airlines </h1> <h2>No booking found with the id:" + id + " </h2>";
		return "<h1>Welcome to ABC Airlines </h1> " +
		"<h2>Your booking has been confirmed. Kindly refer the details: </h2>" +
		"<strong>Booking ID: </strong>" +  booking.getId()  +
		"<br><strong>Name: </strong>" + booking.getPassenger().getName() + 
		"<br><strong>Age: </strong> "+  booking.getPassenger().getAge() + 
		"<br><strong>Gender: </strong>" + booking.getPassenger().getGender() + 
		"<br><strong>Source: </strong>"+ booking.getFlight().getSource() + 
		"<br><strong>Destination: </strong>" + booking.getFlight().getDestination() + 
		"<br><strong>Preferred Class: </strong> "+ booking.getPreferredClass() +
		"<br><strong>Fare: </strong>" + booking.getFare();
	}


	@GetMapping("/all-bookings")
	public List<Booking> getAllBookings() {
		return bookingService.getBookings();
	}

}
