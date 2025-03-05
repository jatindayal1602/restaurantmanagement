package com.jatin.restaurantmanagement.Repo.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jatin.restaurantmanagement.Data.menu.MenuItem;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategory(String category);

     @Query("SELECT DISTINCT m.category FROM MenuItem m")
    List<String> findDistinctCategories();
}
