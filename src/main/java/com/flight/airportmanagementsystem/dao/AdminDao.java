package com.flight.airportmanagementsystem.dao;

import com.flight.airportmanagementsystem.dto.Admin;

public interface AdminDao {
	
	public Admin fetchAdminByEmailForLoginDao(String email);

}
