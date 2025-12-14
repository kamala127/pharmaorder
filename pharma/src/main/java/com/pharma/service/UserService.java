package com.pharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pharma.dao.UserRepository;
import com.pharma.entity.RoleType;
import com.pharma.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register User
    public String registerUser(User user) {
        if (userRepository.existsByUserEmail(user.getUserEmail())) {
            return "User already exists with this email!";
        }

     // If role not provided, assign default
        if (user.getRole() == null) {
            user.setRole(RoleType.ADMIN);
        }
        
        
        // Hash the password before saving
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        userRepository.save(user);
        return "User registered successfully!";
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    
    // Delete All Users
    public String deleteAll() {
    	userRepository.deleteAll();
    	return "Deleted";
    }
}
