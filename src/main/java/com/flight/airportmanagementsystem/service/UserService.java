package com.flight.airportmanagementsystem.service;

import com.flight.airportmanagementsystem.dto.User;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;

public interface UserService {
	
	public ApplicationResponse<User> fetchUserByEmailForLoginService(String email, String password);
	
	public ApplicationResponse<User> userRegisterService(User user);
}
