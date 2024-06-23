package com.flight.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.BookingDetailsDao;
import com.flight.airportmanagementsystem.dto.BookingDetails;
import com.flight.airportmanagementsystem.repository.BookingDetailsRepository;

@Repository
public class BookingDetailsDaoImpl implements BookingDetailsDao {
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	
	@Override
	public BookingDetails saveBookingDetailsDao(BookingDetails bookingDetails) {
	   return bookingDetailsRepository.save(bookingDetails);
	}


}
