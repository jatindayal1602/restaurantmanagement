package com.jatin.restaurantmanagement.Data.order;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate = new Date();

    private String status = "PENDING"; // PENDING, COMPLETED

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderDetail> orderDetails;

    private double totalAmount;
}
