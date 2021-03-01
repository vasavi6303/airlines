package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Passenger;

public interface PassengerService {
	
	public Boolean save(Passenger p);

	public Passenger getPassengerById(int id);
	
	public Passenger getPassengerByName(String name);

	public List<Passenger> getCustomers();
	
	public void deletePassengerById(int id);

}
