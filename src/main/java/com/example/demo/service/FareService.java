package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Fare;


public interface FareService {
	
	public Boolean save(Fare f);

	public Fare getFareById(int id);
	

	public List<Fare> getFares();
	
	public void deleteFareById(int id);
	
	public Fare getFareBySourceAndDestination(String source, String destination);

}
