package com.techtodo.tectodolistbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.techtodo.tectodolistbackend.entity.User;
import com.techtodo.tectodolistbackend.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	   
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User registerUser (User user) {
		
		 if(userRepository.existsByuserName(user.getUserName())) {
			  throw new RuntimeException("UserName already in use");
		 }
		 
		 if(userRepository.existsByEmail(user.getEmail())) {
			 throw new RuntimeException("Email already in Use");
			 
		 }
		return userRepository.save(user);
	}

	public String loginUser(User user) {
		
		return null;
	}

	public String generateJwtToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	
	   
	
		
	

}
