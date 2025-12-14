package com.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.entity.User;
import com.pharma.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
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
}
