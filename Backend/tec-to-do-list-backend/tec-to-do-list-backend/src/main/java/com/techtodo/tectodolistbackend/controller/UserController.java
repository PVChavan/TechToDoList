package com.techtodo.tectodolistbackend.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtodo.tectodolistbackend.entity.User;
import com.techtodo.tectodolistbackend.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	 private UserService userService;
	 private AuthenticationManager authenticationManager;
      
	 @PostMapping("/register")
	    public ResponseEntity<?> registerUser(@RequestBody User user) {
	        try {
	            User registeredUser = userService.registerUser(user);
	            return ResponseEntity.ok(registeredUser);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
	        }
	    }
	 
	 @PostMapping("/login")
	 public ResponseEntity<?> loginUser(@RequestBody User user, String username) {
	     try {
	        
	         Authentication authentication = authenticationManager.authenticate(
	                 new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
	         );

	         // If authentication is successful, the user is valid
	         if (authentication.isAuthenticated()) {
	        	 UserDetailsService userDetailsService = null;
	        	
	            
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	             String token = userService.generateJwtToken(userDetails);
	             return ResponseEntity.ok(token);
	         }
	     } catch (Exception e) {
	         // Authentication failed
	         return ResponseEntity.badRequest().body("Authentication failed: " + e.getMessage());
	     }

	     return ResponseEntity.badRequest().body("Authentication failed");
	 }
}
