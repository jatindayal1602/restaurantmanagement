package com.jatin.restaurantmanagement.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatin.restaurantmanagement.Data.User;
import com.jatin.restaurantmanagement.Model.UserRegistrationDTO;
import com.jatin.restaurantmanagement.Repo.user.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //   @Autowired
    // private RoleRepository roleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(UserRegistrationDTO registrationDTO) {
        if (userRepository.findByEmail(registrationDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // // Fetch role from database
        // Optional<Role> role = roleRepository.findByName(registrationDTO.getRole());
        // if (role.isEmpty()) {
        //     throw new RuntimeException("Invalid role");
        // }

        // Create new user WITHOUT password encryption
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword()); // Plain text (Not secure!)


        return userRepository.save(user);
    }
}
