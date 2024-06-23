package com.flight.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.airportmanagementsystem.dto.BookingDetails;
import com.flight.airportmanagementsystem.dto.Flight;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, String>{
	
	
}
