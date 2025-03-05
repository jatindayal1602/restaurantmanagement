package com.jatin.restaurantmanagement.Data;


import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int popularity; // Out of 10

    @Column(nullable = false)
    private String category;

    public MenuItem() {}

    public MenuItem(String name, double price, int popularity, String category) {
        this.name = name;
        this.price = price;
        this.popularity = popularity;
        this.category = category;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
