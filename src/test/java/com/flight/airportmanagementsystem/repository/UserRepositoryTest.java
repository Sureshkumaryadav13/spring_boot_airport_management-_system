package com.flight.airportmanagementsystem.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.flight.airportmanagementsystem.dto.User;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
	
	@Mock
	private UserRepository userRepository;
	
	User user = null;
	
	@BeforeEach
	public void test() {
		
		user = new User(121, "kumar", "kumar123@gmail.com", "kumar123");
	}
	
	@Test
	public void testFindByUserEmail() {
		
		when(userRepository.findByUserEmail("kumar123@gmail.com")).thenReturn(user);
		
		User found = userRepository.findByUserEmail("kumar123@gmail.com");
		
		assertThat(found).isNotNull();
		assertThat(found.getUserEmail()).isEqualTo("kumar123@gmail.com");
	}
}
