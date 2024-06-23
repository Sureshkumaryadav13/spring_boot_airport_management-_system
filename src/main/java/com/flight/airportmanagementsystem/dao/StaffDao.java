package com.flight.airportmanagementsystem.dao;

import com.flight.airportmanagementsystem.dto.Staff;

public interface StaffDao {
	
	public Staff fetchStaffByEmailForLoginDao(String email);
	
	public Staff staffRegisterDao(Staff staff);
}
