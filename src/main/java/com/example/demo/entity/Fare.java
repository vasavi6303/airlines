package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { "source", "destination", "businessClassFare", "economyClassFare"})
@Entity
public class Fare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	int id;
	
	@Column(name = "source", nullable = false)
	String source;
	
	@Column(name = "destination", nullable = false)
	String destination;
	
	
	@Column(name = "business_class_fare", nullable = false)
	int businessClassFare;
	
	@Column(name = "economy_class_fare", nullable = false)
	int economyClassFare;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestinaton() {
		return destination;
	}

	public void setDestinaton(String destinaton) {
		this.destination = destinaton;
	}

	public int getBusinessClassFare() {
		return businessClassFare;
	}

	public void setBusinessClassFare(int businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	public int getEconomyClassFare() {
		return economyClassFare;
	}

	public void setEconomyClassFare(int economyClassFare) {
		this.economyClassFare = economyClassFare;
	}

}
