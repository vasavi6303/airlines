package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepo;
	
	@Override
	public Boolean save(Booking b) {
		bookingRepo.save(b);
		return true;
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
	

}
