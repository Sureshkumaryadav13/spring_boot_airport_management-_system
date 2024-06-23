package com.flight.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.airportmanagementsystem.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	
	public Staff  findByStaffEmail(String staffEmail);
}
