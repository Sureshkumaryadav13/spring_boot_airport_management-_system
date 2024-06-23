package com.flight.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.StaffDao;
import com.flight.airportmanagementsystem.dto.Staff;
import com.flight.airportmanagementsystem.repository.StaffRepository;

@Repository
public class StaffDaoImpl implements StaffDao{
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public Staff fetchStaffByEmailForLoginDao(String email) {
		
		return staffRepository.findByStaffEmail(email);
	}

	@Override
	public Staff staffRegisterDao(Staff staff) {
		
		return staffRepository.save(staff);
	}

}
