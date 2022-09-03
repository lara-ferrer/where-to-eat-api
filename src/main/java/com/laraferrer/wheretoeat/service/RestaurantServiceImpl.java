package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Category;
import com.laraferrer.wheretoeat.domain.City;
import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.dto.RestaurantDTO;
import com.laraferrer.wheretoeat.exception.CategoryNotFoundException;
import com.laraferrer.wheretoeat.exception.CityNotFoundException;
import com.laraferrer.wheretoeat.exception.RestaurantNotFoundException;
import com.laraferrer.wheretoeat.repository.CategoryRepository;
import com.laraferrer.wheretoeat.repository.CityRepository;
import com.laraferrer.wheretoeat.repository.RestaurantRepository;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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
    public Restaurant addRestaurant(RestaurantDTO restaurantDTO) throws CityNotFoundException, CategoryNotFoundException {
        City city = cityRepository.findById(restaurantDTO.getCityId())
                .orElseThrow(CityNotFoundException::new);
        Category category = categoryRepository.findById(restaurantDTO.getCategoryId())
                .orElseThrow(CategoryNotFoundException::new);

        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurant.getId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setPhone(restaurantDTO.getPhone());
        restaurant.setEmail(restaurantDTO.getEmail());
        restaurant.setCity(city);
        restaurant.setCategory(category);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant modifyRestaurant(long restaurantId, RestaurantDTO restaurantDTO) throws RestaurantNotFoundException, CityNotFoundException, CategoryNotFoundException {
        Restaurant newRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);
        City city = cityRepository.findById(restaurantDTO.getCityId())
                .orElseThrow(CityNotFoundException::new);
        Category category = categoryRepository.findById(restaurantDTO.getCategoryId())
                .orElseThrow(CategoryNotFoundException::new);

        newRestaurant.setName(restaurantDTO.getName());
        newRestaurant.setAddress(restaurantDTO.getAddress());
        newRestaurant.setPhone(restaurantDTO.getPhone());
        newRestaurant.setEmail(restaurantDTO.getEmail());
        newRestaurant.setCity(city);
        newRestaurant.setCategory(category);

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
