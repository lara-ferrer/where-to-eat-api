package com.laraferrer.wheretoeat.controller;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import com.laraferrer.wheretoeat.service.RestaurantService;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
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
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        List<Restaurant> restaurants = null;
        restaurants = restaurantService.findAllRestaurants();

        return ResponseEntity.ok(restaurants);
    }

    @PostMapping(value = "/restaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @PutMapping(value = "/restaurant/{restaurantId}")
    public ResponseEntity<Restaurant> modifyRestaurant(@PathVariable long restaurantId, @RequestBody Restaurant restaurant) throws RestaurantNotFoundException {
        Restaurant newRestaurant = restaurantService.modifyRestaurant(restaurantId, restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.OK);
    }

    @PatchMapping(value = "/restaurant/{restaurantId}")
    public ResponseEntity<Void> patchRestaurant(@PathVariable long restaurantId, @RequestBody PatchDTO patchDTO) throws RestaurantNotFoundException {
        restaurantService.patchRestaurant(restaurantId, patchDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/restaurant/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable long restaurantId) throws RestaurantNotFoundException {
        restaurantService.deleteRestaurantById(restaurantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}