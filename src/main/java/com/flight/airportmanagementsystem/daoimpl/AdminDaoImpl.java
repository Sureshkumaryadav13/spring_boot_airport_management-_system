package com.flight.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.AdminDao;
import com.flight.airportmanagementsystem.dto.Admin;
import com.flight.airportmanagementsystem.repository.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao {
    
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin fetchAdminByEmailForLoginDao(String email) {
		
		return adminRepository.findByAdminEmail(email);
	}
	
	

}
