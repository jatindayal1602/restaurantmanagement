package com.jatin.restaurantmanagement.exceptions;


public class MenuItemNotFoundException extends RuntimeException {
    public MenuItemNotFoundException(String message) {
        super(message);
    }
}
