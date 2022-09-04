package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.dto.RestaurantDTO;
import com.laraferrer.wheretoeat.exception.CategoryNotFoundException;
import com.laraferrer.wheretoeat.exception.CityNotFoundException;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import com.laraferrer.wheretoeat.dto.PatchDTO;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAllRestaurants();
    Restaurant findNameById(long id) throws RestaurantNotFoundException;
    Restaurant addRestaurant(RestaurantDTO restaurantDTO) throws CityNotFoundException, CategoryNotFoundException;
    Restaurant modifyRestaurant(long restaurantId, RestaurantDTO restaurantDTO) throws RestaurantNotFoundException, CityNotFoundException, CategoryNotFoundException;
    void patchRestaurant(long restaurantId, PatchDTO patchDTO) throws RestaurantNotFoundException;
    void deleteRestaurantById(long restaurantId) throws RestaurantNotFoundException;
}
