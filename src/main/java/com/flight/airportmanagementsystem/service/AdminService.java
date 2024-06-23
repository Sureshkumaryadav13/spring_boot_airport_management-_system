package com.flight.airportmanagementsystem.service;

import com.flight.airportmanagementsystem.dto.Admin;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;

public interface AdminService {
	
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(String email, String password);

}
