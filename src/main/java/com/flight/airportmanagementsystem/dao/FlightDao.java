package com.flight.airportmanagementsystem.dao;

import java.util.List;

import com.flight.airportmanagementsystem.dto.Flight;

public interface FlightDao {
	
	public Flight saveFlightDetailsDao(Flight flight);
	public List<Flight> getFlightWithSourceAndDestinationDao(String source, String destination);
	public Flight getFlightByFlightNumber(String flightNumber);
}
