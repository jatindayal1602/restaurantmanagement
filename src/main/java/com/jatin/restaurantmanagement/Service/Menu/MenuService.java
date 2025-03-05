package com.jatin.restaurantmanagement.Service.Menu;

import com.jatin.restaurantmanagement.Data.menu.MenuItem;
import com.jatin.restaurantmanagement.Repo.Menu.MenuItemRepository;
import com.jatin.restaurantmanagement.exceptions.MenuItemNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuItemRepository itemRepository;

    public List<MenuItem> getAllItems() {
        return itemRepository.findAll();
    }

    public MenuItem getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu item with ID " + id + " not found"));
    }

    public MenuItem createItem(MenuItem item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new MenuItemNotFoundException("Menu item with ID " + id + " does not exist");
        }
        itemRepository.deleteById(id);
    }

    public List<MenuItem> getItemsByCategory(String category) {
        List<MenuItem> items = itemRepository.findByCategory(category);
        if (items.isEmpty()) {
            throw new MenuItemNotFoundException("No items found in category: " + category);
        }
        return items;
    }

    public List<String> getDistinctCategories() {
        List<String> categories = itemRepository.findDistinctCategories();
        if (categories.isEmpty()) {
            throw new MenuItemNotFoundException("No categories found in the menu");
        }
        return categories;
    }
}
