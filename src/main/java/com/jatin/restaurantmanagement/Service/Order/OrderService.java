package com.jatin.restaurantmanagement.Service.Order;

import com.jatin.restaurantmanagement.Data.menu.MenuItem;
import com.jatin.restaurantmanagement.Data.order.Order;
import com.jatin.restaurantmanagement.Data.order.OrderDetail;
import com.jatin.restaurantmanagement.Repo.Menu.MenuItemRepository;
import com.jatin.restaurantmanagement.Repo.Order.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public Order placeOrder(Order order) {
        double total = 0;

        for (OrderDetail detail : order.getOrderDetails()) {
            Optional<MenuItem> existingMenuItem = menuItemRepository.findById(detail.getMenuItem().getId());
            if (existingMenuItem.isPresent()) {
                MenuItem menuItem = existingMenuItem.get();
                detail.setMenuItem(menuItem);
                total += menuItem.getPrice() * detail.getQuantity();
            } else {
                throw new RuntimeException("MenuItem with ID " + detail.getMenuItem().getId() + " does not exist.");
            }
        }

        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
