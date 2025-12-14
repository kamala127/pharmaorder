package com.pharma.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUserEmail(String email); // optional for checking duplicates

    Optional<User> findByUserName(String userName);
}
