package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // This allows us to find users by username automatically!
    User findByUsername(String username);
}