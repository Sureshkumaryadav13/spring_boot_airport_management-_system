package com.flight.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.BookingDetailsDao;
import com.flight.airportmanagementsystem.dao.FlightDao;
import com.flight.airportmanagementsystem.dao.UserDao;
import com.flight.airportmanagementsystem.dto.BookingDetails;
import com.flight.airportmanagementsystem.dto.Flight;
import com.flight.airportmanagementsystem.dto.User;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.BookingDetailsService;

import jakarta.servlet.http.HttpSession;

@Repository
public class BookingDetailsServiceImpl implements BookingDetailsService{
	
	@Autowired
	private BookingDetailsDao bookingDetailsDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private ApplicationResponse<BookingDetails> applicationResponse;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<BookingDetails> saveBookingDetailsService(BookingDetails bookingDetails) {
		
		String email = (String)httpSession.getAttribute("user");
		User user = userDao.fetchUserByEmailForLoginDao(email);
		
		Flight flight = flightDao.getFlightByFlightNumber(bookingDetails.getFlight().getFlightNumber());
		
		bookingDetails.setFlight(flight);
		bookingDetails.setUser(user);
		bookingDetails.setTotalPrice(bookingDetails.getFlight().getFlightPrice() + bookingDetails.getConvenienceFee());
		bookingDetailsDao.saveBookingDetailsDao(bookingDetails);
		return applicationResponse;
	}
}
