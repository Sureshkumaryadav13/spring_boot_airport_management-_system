package com.flight.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.airportmanagementsystem.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin  findByAdminEmail(String adminEmail);

}
