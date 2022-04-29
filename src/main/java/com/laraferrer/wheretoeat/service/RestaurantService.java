package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAllRestaurants();
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant modifyRestaurant(long productId, Restaurant restaurant) throws RestaurantNotFoundException;
}
