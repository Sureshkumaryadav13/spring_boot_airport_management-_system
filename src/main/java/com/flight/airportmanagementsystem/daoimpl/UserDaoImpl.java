package com.flight.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flight.airportmanagementsystem.dao.UserDao;
import com.flight.airportmanagementsystem.dto.User;
import com.flight.airportmanagementsystem.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User fetchUserByEmailForLoginDao(String email) {
		
		return userRepository.findByUserEmail(email);
	}

	@Override
	public User userRegisterDao(User user) {
		
		return userRepository.save(user);
	}

}
