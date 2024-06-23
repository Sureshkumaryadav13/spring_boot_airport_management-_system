package com.flight.airportmanagementsystem.service;

import java.util.List;

import com.flight.airportmanagementsystem.dto.Flight;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;

public interface FlightService {
	
	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight);
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(String source, String destination);
}
