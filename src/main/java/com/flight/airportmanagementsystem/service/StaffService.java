package com.flight.airportmanagementsystem.service;

import com.flight.airportmanagementsystem.dto.Staff;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;

public interface StaffService {
	
	public ApplicationResponse<Staff> fetchStaffByEmailForLoginService(String email, String password);
	
	public ApplicationResponse<Staff> staffRegisterService(Staff staff);
}
