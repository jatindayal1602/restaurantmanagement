package com.jatin.restaurantmanagement.Data.menu;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price; // Price in Rupees

    @Column(nullable = false)
    private int popularity; // Out of 10

    @Column(nullable = false)
    private String category;
}
