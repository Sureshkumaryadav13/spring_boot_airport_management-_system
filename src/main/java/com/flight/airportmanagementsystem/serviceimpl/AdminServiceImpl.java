package com.flight.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.AdminDao;
import com.flight.airportmanagementsystem.dto.Admin;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Repository
public class AdminServiceImpl implements AdminService {
    
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ApplicationResponse<Admin> applicationResponse;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(String email, String password) {
		
		Admin admin = adminDao.fetchAdminByEmailForLoginDao(email);
		
		if(admin != null) {
			
			if(admin.getAdminPassword().equals(password)) {
				
				httpSession.setAttribute("admin", admin.getAdminEmail());
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("admin logged in successfully...");
				applicationResponse.setDescription("admin logged in and session is create with email");
				admin.setAdminPassword("**********");
				applicationResponse.setData(admin);
				
				return applicationResponse;
			}else {
				
				applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
				applicationResponse.setMessage("Password is incorrect");
				applicationResponse.setDescription("please pass correct password and check");
				applicationResponse.setData(null);
				
				return applicationResponse;
			}
		}else {
			
			applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			applicationResponse.setMessage("Email is incorrect");
			applicationResponse.setDescription("please pass correct email and check");
			applicationResponse.setData(null);
			
			return applicationResponse;
		}
	}

}
