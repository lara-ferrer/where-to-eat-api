package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAllRestaurants();
    Restaurant addRestaurant(Restaurant restaurant);
}
