package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;

public interface BookingService {
	
	public Boolean save(Booking b);
	
	public Booking getBookingById(int id);
	
	public List<Booking> getBookings();
	
	public void deleteBookingById(int id);
	
}
