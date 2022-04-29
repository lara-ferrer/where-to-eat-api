package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import com.laraferrer.wheretoeat.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant modifyRestaurant(long restaurantId, Restaurant restaurant) throws RestaurantNotFoundException {
        Restaurant newRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);
        newRestaurant.setId(restaurant.getId());
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setPhone(restaurant.getPhone());
        newRestaurant.setEmail(restaurant.getEmail());
        newRestaurant.setCategoryId(restaurant.getCategoryId());

        return restaurantRepository.save(newRestaurant);
    }
}
