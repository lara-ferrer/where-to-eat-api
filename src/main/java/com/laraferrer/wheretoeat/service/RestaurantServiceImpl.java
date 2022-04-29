package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import com.laraferrer.wheretoeat.repository.RestaurantRepository;
import com.laraferrer.wheretoeat.dto.RestaurantPatchDTO;
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

    @Override
    public void patchRestaurant(long restaurantId, RestaurantPatchDTO restaurantPatchDTO) throws RestaurantNotFoundException {
        Restaurant newRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);
        if (restaurantPatchDTO.getKey().equals("name")) {
            newRestaurant.setName(restaurantPatchDTO.getValue());
        }
        if (restaurantPatchDTO.getKey().equals("address")) {
            newRestaurant.setAddress(restaurantPatchDTO.getValue());
        }
        if (restaurantPatchDTO.getKey().equals("city")) {
            newRestaurant.setName(restaurantPatchDTO.getValue());
        }
        if (restaurantPatchDTO.getKey().equals("phone")) {
            newRestaurant.setName(restaurantPatchDTO.getValue());
        }
        if (restaurantPatchDTO.getKey().equals("email")) {
            newRestaurant.setName(restaurantPatchDTO.getValue());
        }
        if (restaurantPatchDTO.getKey().equals("categoryId")) {
            newRestaurant.setCategoryId(Integer.parseInt(restaurantPatchDTO.getValue()));
        }

        restaurantRepository.save(newRestaurant);
    }

    @Override
    public void deleteRestaurantById(long productId) throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantRepository.findById(productId)
                .orElseThrow(RestaurantNotFoundException::new);
        restaurantRepository.delete(restaurant);
    }
}
