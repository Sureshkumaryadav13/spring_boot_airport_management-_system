package com.flight.airportmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.airportmanagementsystem.dto.User;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/userLoginByEmail/{email}/{password}")
	public ApplicationResponse<User> fetchUserByEmailForLoginController(@PathVariable String email,@PathVariable String password) {
		
		return userService.fetchUserByEmailForLoginService(email, password);
	}
	
	
	@PostMapping(value = "/saveUser")
	public ApplicationResponse<User> userRegisterController(@RequestBody User user) {
		
		return userService.userRegisterService(user);
	}
}
