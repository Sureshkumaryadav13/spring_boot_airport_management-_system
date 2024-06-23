package com.flight.airportmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.FlightDao;
import com.flight.airportmanagementsystem.dto.Flight;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.FlightService;

import jakarta.servlet.http.HttpSession;

@Repository
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private ApplicationResponse<Flight> applicationResponse;
	
	@Autowired
	private ApplicationResponse<List<Flight>> listResponse;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight) {
		
		if(httpSession.getAttribute("admin") != null) {
			
			Flight flight2 = flightDao.saveFlightDetailsDao(flight);
			if(flight2 != null) {
				
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("Flight---Details--Addadd");
				applicationResponse.setDescription("you con follow below data what is addedd");
				applicationResponse.setData(flight2);
				
				return applicationResponse;
			}else {
				
				applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				applicationResponse.setMessage("you are loged in with admin");
				applicationResponse.setDescription("But there might be problem with database.... ");
				applicationResponse.setData(null);
				
				return applicationResponse;
			}
		}else {
			
			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("you are loged in with admin");
			applicationResponse.setDescription("But there might be problem with database.... ");
			applicationResponse.setData(null);
			
			return applicationResponse;
		}
	}

	@Override
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(String source, String destination) {
		
		List<Flight> flights = flightDao.getFlightWithSourceAndDestinationDao(source, destination);
		
		if(httpSession.getAttribute("user") != null ) {
			
			if(!flights.isEmpty()) {
				httpSession.setAttribute("flight", flights);
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("flight is Available");
				applicationResponse.setDescription("please choose flight among the following flight");
				listResponse.setData(flights);
				
				return listResponse;
			}else {
				
				applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
				applicationResponse.setMessage("flight is not found");
				applicationResponse.setDescription("flight is not available source to destination...");
				applicationResponse.setData(null);
				
				return listResponse;
			}
		}else {
			
			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("user is not fount...");
			applicationResponse.setDescription("please user session is not created...");
			applicationResponse.setData(null);
			
			return listResponse;
		}
	}

}
