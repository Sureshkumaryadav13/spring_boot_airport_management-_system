package com.flight.airportmanagementsystem.dao;

import com.flight.airportmanagementsystem.dto.User;

public interface UserDao {
	
	public User fetchUserByEmailForLoginDao(String email);
	
	public User userRegisterDao(User user);

}
