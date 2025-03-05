package com.jatin.restaurantmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jatin.restaurantmanagement.Data.menu.MenuItem;
import com.jatin.restaurantmanagement.Service.Menu.MenuService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/items")
    public List<MenuItem> getAllItems() {
        return menuService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Optional<MenuItem> getItemById(@PathVariable Long id) {
        return menuService.getItemById(id);
    }

    @PostMapping("/items")
    public MenuItem createItem(@RequestBody MenuItem item) {
        return menuService.createItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        menuService.deleteItem(id);
    }
    @GetMapping("/categories")
    public List<String> getDistinctCategories() {
        return menuService.getDistinctCategories();
    }

    @GetMapping("/items/category/{category}")
    public List<MenuItem> getItemsByCategory(@PathVariable String category) {
        return menuService.getItemsByCategory(category);
    }
}
