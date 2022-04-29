package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import com.laraferrer.wheretoeat.dto.RestaurantPatchDTO;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAllRestaurants();
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant modifyRestaurant(long restaurantId, Restaurant restaurant) throws RestaurantNotFoundException;
    void patchRestaurant(long restaurantId, RestaurantPatchDTO restaurantPatchDTO) throws RestaurantNotFoundException;
    void deleteRestaurantById(long restaurantId) throws RestaurantNotFoundException;
}
