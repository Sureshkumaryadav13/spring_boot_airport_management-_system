package com.flight.airportmanagementsystem.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {
	
	@Id
	private String pnr;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private LocalDate journeyDate;
	private LocalDate bookingDate;
	private double totalPrice;
	private int convenienceFee;
	private String cancel;
	
	private String bording;
	
	@ManyToOne
	@JoinColumn(name = "user-id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "flightNumber")
	private Flight flight;
}
