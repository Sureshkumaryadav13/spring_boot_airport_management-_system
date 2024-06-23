package com.flight.airportmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.airportmanagementsystem.dto.BookingDetails;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.BookingDetailsService;

@RestController
@RequestMapping(value = "/bookingDetails")
public class BookingDetailsController {
	
	@Autowired
	private BookingDetailsService bookingDetailsService;
	
	
	@PostMapping(value = "/saveBookingDetails")
	public ApplicationResponse<BookingDetails> saveBookingDetailsDao(@RequestBody BookingDetails bookingDetails) {
		
	   return bookingDetailsService.saveBookingDetailsService(bookingDetails);
	}
 
}
