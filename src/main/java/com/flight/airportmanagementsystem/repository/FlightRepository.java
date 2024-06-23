package com.flight.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.airportmanagementsystem.dto.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{
	
	public Flight findByFlightNumber(String flightNumber);
}
