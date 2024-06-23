package com.flight.airportmanagementsystem.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.FlightDao;
import com.flight.airportmanagementsystem.dto.Flight;
import com.flight.airportmanagementsystem.repository.FlightRepository;

@Repository
public class FlightDaoImpl implements FlightDao {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public Flight saveFlightDetailsDao(Flight flight) {
		
		return flightRepository.save(flight);
	}

	@Override
	public List<Flight> getFlightWithSourceAndDestinationDao(String source, String destination) {
		
		List<Flight> flights = flightRepository.findAll();
		
		flights.stream()
		.filter(a -> a.getFlightSource().equalsIgnoreCase(source) && a.getFlightDestination().equalsIgnoreCase(destination)).toList();
		
		return flights;
	}

	@Override
	public Flight getFlightByFlightNumber(String flightNumber) {
		
		return flightRepository.findByFlightNumber(flightNumber);
	}

}
