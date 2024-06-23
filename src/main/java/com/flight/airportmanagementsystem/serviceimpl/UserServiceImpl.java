package com.flight.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.UserDao;
import com.flight.airportmanagementsystem.dto.User;
import com.flight.airportmanagementsystem.respose.ApplicationResponse;
import com.flight.airportmanagementsystem.service.UserService;

import jakarta.servlet.http.HttpSession;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ApplicationResponse<User> applicationResponse;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<User> fetchUserByEmailForLoginService(String email, String password) {
		
		User user = userDao.fetchUserByEmailForLoginDao(email);
		
		if(user != null) {
			
			if(user.getUserPassword().equals(password)) {
				
				httpSession.setAttribute("user", user.getUserEmail() );
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("User logged is Sucessfully...");
				applicationResponse.setDescription("User logged in and session is create with email");
				user.setUserPassword("***************");
				applicationResponse.setData(user);
				
				return applicationResponse;
				
			}else {
				
				applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
				applicationResponse.setMessage("User Passwprd incorrect");
				applicationResponse.setDescription("User pass correct Password and check");
				applicationResponse.setData(null);
				
				return applicationResponse;
			}
		}else {
			
			applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			applicationResponse.setMessage("User Email incorrect");
			applicationResponse.setDescription("Please pass correct Email and check");
			applicationResponse.setData(null);
			
			return applicationResponse;
		}
	}

	@Override
	public ApplicationResponse<User> userRegisterService(User user) {
		
		User user2 = userDao.userRegisterDao(user);
		
		if(user2 != null) {
			
			applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			applicationResponse.setMessage("User Register is Successfully");
			applicationResponse.setDescription("user register successfully and session is created");
			applicationResponse.setData(user2);
			
			return applicationResponse;
		}else {
			
			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("User Register is not successfully");
			applicationResponse.setDescription("please check your details user");
			applicationResponse.setData(null);
			
			return applicationResponse;
		}
		
	}

}
