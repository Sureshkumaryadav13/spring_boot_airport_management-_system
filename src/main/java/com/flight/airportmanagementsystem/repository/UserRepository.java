package com.flight.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.airportmanagementsystem.dto.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User  findByUserEmail(String userEmail);
}
