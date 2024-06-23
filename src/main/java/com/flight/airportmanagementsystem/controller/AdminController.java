package com.flight.airportmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.airportmanagementsystem.dto.Admin;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping(value = "/loginAdmin/{email}/{password}")
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginController(@PathVariable String email,@PathVariable String password) {
		
		return adminService.fetchAdminByEmailForLoginService(email, password);
	}

}
