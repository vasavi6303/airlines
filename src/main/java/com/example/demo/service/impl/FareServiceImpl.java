package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Fare;
import com.example.demo.repository.FareRepository;
import com.example.demo.service.FareService;

@Service
public class FareServiceImpl implements FareService{

	@Autowired
	private FareRepository fareRepo;
	
	@Override
	public Boolean save(Fare f) {
		fareRepo.save(f);
		return null;
	}

	@Override
	public Fare getFareById(int id) {
		return fareRepo.findById(id).orElse(null);
	}

	@Override
	public List<Fare> getFares() {
		return fareRepo.findAll();
	}

	@Override
	public void deleteFareById(int id) {
	  fareRepo.deleteById(id);
		
	}

	@Override
	public Fare getFareBySourceAndDestination(String source, String destination) {
		return fareRepo.findBySourceAndDestination(source, destination);
	}

}
