package com.flight.airportmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.airportmanagementsystem.dto.Staff;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.StaffService;

@RestController
@RequestMapping(value = "/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping(value = "/staffLoginByEmail/{email}/{password}")
	public ApplicationResponse<Staff> fetchStaffByEmailForLoginController(@PathVariable String email,@PathVariable String password){
		
		return staffService.fetchStaffByEmailForLoginService(email, password);
	}
	
	@PostMapping(value = "/saveStaff")
	public ApplicationResponse<Staff> saveStaff(@RequestBody Staff staff){
		
		return staffService.staffRegisterService(staff);
	}
}
