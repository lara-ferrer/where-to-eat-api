package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.dto.RestaurantDTO;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import com.laraferrer.wheretoeat.repository.RestaurantRepository;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public RestaurantDTO findNameById(long restaurantId) throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setName(restaurant.getName());

        return restaurantDTO;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant modifyRestaurant(long restaurantId, Restaurant restaurant) throws RestaurantNotFoundException {
        Restaurant newRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);
        newRestaurant.setRestaurantId(restaurant.getRestaurantId());
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setPhone(restaurant.getPhone());
        newRestaurant.setEmail(restaurant.getEmail());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setCategory(restaurant.getCategory());

        return restaurantRepository.save(newRestaurant);
    }

    @Override
    public void patchRestaurant(long restaurantId, PatchDTO patchDTO) throws RestaurantNotFoundException {
        Restaurant newRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);
        if (patchDTO.getKey().equals("name")) {
            newRestaurant.setName(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("address")) {
            newRestaurant.setAddress(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("phone")) {
            newRestaurant.setName(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("email")) {
            newRestaurant.setName(patchDTO.getValue());
        }

        restaurantRepository.save(newRestaurant);
    }

    @Override
    public void deleteRestaurantById(long restaurantId) throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);
        restaurantRepository.delete(restaurant);
    }
}
