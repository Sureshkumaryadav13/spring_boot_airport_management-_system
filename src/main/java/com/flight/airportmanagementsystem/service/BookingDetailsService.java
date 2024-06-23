package com.flight.airportmanagementsystem.service;

import com.flight.airportmanagementsystem.dto.BookingDetails;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;

public interface BookingDetailsService {
	
	public ApplicationResponse<BookingDetails> saveBookingDetailsService(BookingDetails bookingDetails);

}
