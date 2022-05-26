package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.dto.RestaurantDTO;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import com.laraferrer.wheretoeat.dto.PatchDTO;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAllRestaurants();
    RestaurantDTO findNameById(long id) throws RestaurantNotFoundException;
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant modifyRestaurant(long restaurantId, Restaurant restaurant) throws RestaurantNotFoundException;
    void patchRestaurant(long restaurantId, PatchDTO patchDTO) throws RestaurantNotFoundException;
    void deleteRestaurantById(long restaurantId) throws RestaurantNotFoundException;
}
