package com.jatin.restaurantmanagement.Repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.restaurantmanagement.Data.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
