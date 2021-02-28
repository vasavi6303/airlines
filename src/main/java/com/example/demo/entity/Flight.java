package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "source", nullable = false)
	private String source;

	@Column(name = "destination", nullable = false)
	private String destination;

	@Column(name = "business_class_count", nullable = false)
	private int availableBusinessClassSeats = 30;

	@Column(name = "economy_class_count", nullable = false)
	private int availableEconomyClassSeats = 30;

	@Column(name = "date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;

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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
