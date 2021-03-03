package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.common.Common.PreferredClass;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Fare;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Passenger;


public interface BookingService {
	
	public Booking save(Booking b);
	
	public Booking getBookingById(int id);
	
	public List<Booking> getBookings();
	
	public void deleteBookingById(int id);
	
	public Booking confirmBooking(Passenger passenger, Flight flight , Date date, PreferredClass preferredClass, Fare fare);
}
