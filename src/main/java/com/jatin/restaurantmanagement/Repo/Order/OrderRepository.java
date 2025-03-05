package com.jatin.restaurantmanagement.Repo.Order;

import com.jatin.restaurantmanagement.Data.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
