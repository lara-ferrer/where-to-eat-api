package com.laraferrer.wheretoeat.controller;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.service.RestaurantService;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/restaurant")
    public ResponseEntity<List<Restaurant>> getProducts() {
        List<Restaurant> restaurants = null;
        restaurants = restaurantService.findAllRestaurants();

        return ResponseEntity.ok(restaurants);
    }

    @PostMapping(value = "/restaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }
}
