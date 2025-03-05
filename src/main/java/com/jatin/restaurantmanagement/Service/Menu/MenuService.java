package com.jatin.restaurantmanagement.Service.Menu;

import com.jatin.restaurantmanagement.Data.MenuItem;
import com.jatin.restaurantmanagement.Repo.Menu.MenuItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuItemRepository itemRepository;

    public List<MenuItem> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<MenuItem> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public MenuItem createItem(MenuItem item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<MenuItem> getItemsByCategory(String category) {
        return itemRepository.findByCategory(category);
    }
    public List<String> getDistinctCategories() {
        return itemRepository.findDistinctCategories();
    }
}
