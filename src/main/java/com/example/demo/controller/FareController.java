package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Fare;
import com.example.demo.service.FareService;

@RestController
public class FareController {
	
	@Autowired
	FareService fareService;
	
	@GetMapping("/searchall")
	public List<Fare> getFareDetails(){
		return fareService.getFares();
		
	}
	

}
