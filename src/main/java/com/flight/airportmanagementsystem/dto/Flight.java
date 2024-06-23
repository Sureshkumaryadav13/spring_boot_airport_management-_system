package com.flight.airportmanagementsystem.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.RandomAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight implements Serializable,Cloneable,RandomAccess {
	
	@Id
	@Column(name = "number")
	private String flightNumber;
	
	@Column(name = "name")
	private String flightName;
	
	@Column(name = "source")
	private String flightSource;
	
	@Column(name = "destination")
	private String flightDestination;
	
	@Column(name = "status")
	private String flightStatus;
	
	@Column(name = "arrivalTime")
	private LocalTime flightArrivalTime;
	
	@Column(name = "departureTime")
	private LocalTime flightDepartureTime;
	
	@Column(name = "duration")
	private String flightDuration;
	
	@Column(name = "price")
	private double flightPrice;
	
	@Column(name = "seats")
	private int flightNumberSeats;
	
}
