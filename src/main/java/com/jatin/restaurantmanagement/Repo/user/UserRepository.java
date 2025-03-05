package com.jatin.restaurantmanagement.Repo.User;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jatin.restaurantmanagement.Data.user.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
