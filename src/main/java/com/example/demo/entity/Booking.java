package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {
	
	private enum PreferredClass { BusinessClass, EconomyClass}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "on_boarding_date")
	private Date onBoardingDate;
	
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "booked_date")
	private Date bookedDate;
	
	@OneToOne
	private Passenger customer;
	
	@OneToOne
	private Flight flight;
	
	@Column(name = "fare")
	private int fare;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "preferred_class")
	private PreferredClass preferredClass;

}
