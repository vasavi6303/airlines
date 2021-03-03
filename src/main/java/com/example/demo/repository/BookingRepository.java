package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Booking;



@Transactional
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
}
