package com.example.demo.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.Common.PreferredClass;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Fare;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Passenger;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.FareService;
import com.example.demo.service.FlightService;
import com.example.demo.service.PassengerService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	FlightService flightService;

	@Autowired
	PassengerService passengerService;

	@Autowired
	FareService fareService;

	@Autowired
	BookingService bookingService;

	@Override
	public Booking save(Booking b) {
		return bookingRepo.save(b);
	}

	@Override
	public Booking getBookingById(int id) {
		return bookingRepo.findById(id).orElse(null);
	}

	@Override
	public List<Booking> getBookings() {
		return bookingRepo.findAll();
	}

	@Override
	public void deleteBookingById(int id) {
		bookingRepo.deleteById(id);
	}

	@Override
	public Booking confirmBooking(Passenger passenger, Flight flight, Date date, PreferredClass preferredClass,
			Fare fare) {
		Booking booked = null;
		passengerService.save(passenger);
		if(preferredClass == PreferredClass.BusinessClass) 
			booked = bookingService.save(new Booking(passenger, flight, date, fare.getBusinessClassFare(), preferredClass));
		else if(preferredClass == PreferredClass.EconomyClass)
			booked = bookingService.save(new Booking(passenger, flight, date, fare.getEconomyClassFare(), preferredClass));
		
		flightService.updateSeatAvaialability(flight, preferredClass);
		return booked;
	}

}
