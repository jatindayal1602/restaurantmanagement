package com.jatin.restaurantmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jatin.restaurantmanagement.Repo")
public class RestaurantmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantmanagementApplication.class, args);
	}

}
