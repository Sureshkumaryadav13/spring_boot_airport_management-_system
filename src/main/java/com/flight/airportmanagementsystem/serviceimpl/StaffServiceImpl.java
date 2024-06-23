package com.flight.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.StaffDao;
import com.flight.airportmanagementsystem.dto.Staff;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.StaffService;

import jakarta.servlet.http.HttpSession;

@Repository
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffDao staffDao;
	
	@Autowired
	private ApplicationResponse<Staff> applicationResponse;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<Staff> fetchStaffByEmailForLoginService(String email, String password) {
		
		Staff staff = staffDao.fetchStaffByEmailForLoginDao(email);
		
		if(staff != null) {
			
			if(staff.getStaffPassword().equals(password)) {
				httpSession.setAttribute("User", staff.getStaffEmail());
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("Staff logged in sucessfully..");
				applicationResponse.setDescription("Staff logged in and session is create with email");
				staff.setStaffPassword("***********");
				applicationResponse.setData(staff);
				
				return applicationResponse;
			}else {
				
				applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
				applicationResponse.setMessage("Staff password incorrect");
				applicationResponse.setDescription("Staff pass correct password and check");
				applicationResponse.setData(null);
				
				return applicationResponse;
			}
		}else {
			
			applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			applicationResponse.setMessage("Staff Email incorrect");
			applicationResponse.setDescription("Staff pass correct email and check");
			applicationResponse.setData(null);
			
			return applicationResponse;
		}
	}

	@Override
	public ApplicationResponse<Staff> staffRegisterService(Staff staff) {
		
		Staff staff2 = staffDao.staffRegisterDao(staff);
		
		if(staff2 != null) {
			
			return applicationResponse;
		}else {
			
			applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			applicationResponse.setMessage("Staff is not register");
			applicationResponse.setDescription("Staff is check the details");
			applicationResponse.setData(null);
			
			return applicationResponse;
		}
	}

}
