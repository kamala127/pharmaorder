package com.pharma.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.config.JwtUtil;
import com.pharma.entity.LoginRequest;
import com.pharma.entity.User;
import com.pharma.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
	
	
	// Register user
	
	@PostMapping("/createuser")
	public ResponseEntity<String> createUser(@RequestBody User user){
		
		String response = userService.registerUser(user);

        if (response.contains("already exists")) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(response);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
		
	
	// Login user
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginRequest request) {

	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                    request.getUsername(),
	                    request.getPassword()
	            )
	    );

	    // Get logged-in user details
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

	    // Extract role (ROLE_ADMIN / ROLE_USER)
	    String role = userDetails.getAuthorities()
	            .iterator()
	            .next()
	            .getAuthority()
	            .replace("ROLE_", "");

	    // Generate JWT with role
	    String token = jwtUtil.generateToken(userDetails.getUsername(), role);

	    return ResponseEntity.ok(Map.of(
	            "token", token,
	            "type", "Bearer"
	    ));
	}
		

	
	// Get all Users
	@GetMapping("/getAll")
	public ResponseEntity<?> getallUser(){
		List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No users found");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }
	
	@DeleteMapping("/deleteall")
	public String deleteAllUser() {
		return userService.deleteAll();
	}
}
