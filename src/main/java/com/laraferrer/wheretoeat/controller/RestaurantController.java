package com.laraferrer.wheretoeat.controller;

import com.laraferrer.wheretoeat.domain.Restaurant;
import com.laraferrer.wheretoeat.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<Restaurant>> getProducts() {
        List<Restaurant> restaurants = null;
        restaurants = restaurantService.findAllRestaurants();

        return ResponseEntity.ok(restaurants);
    }

    /*// TODO Hacer un pedido
    @PostMapping(value = "/user/{userId}/orders")
    public ResponseEntity<OrderOutDTO> addOrder(@PathVariable long userId, @RequestBody OrderInDTO orderDTO)
            throws ProductNotFoundException, UserNotFoundException {
        User user = userService.findUser(userId);
        Product product = productService.findProduct(orderDTO.getProductId());
        OrderOutDTO orderOutDTO = orderService.addOrder(orderDTO, product, user);
        return new ResponseEntity<>(orderOutDTO, HttpStatus.CREATED);
    }

    // TODO Pedidos de un usuario concreto
    @GetMapping(value = "/user/{userId}/orders")
    public ResponseEntity<List<OrderInDTO>> getOrders(@PathVariable long userId) {
        return null;
    }

    // TODO Eliminar un pedido

    // TODO Modificar un pedido

    // TODO Entregar un pedido

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductNotFoundException pnfe) {
        ErrorResponse errorResponse = new ErrorResponse(101, pnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(UserNotFoundException unfe) {
        ErrorResponse errorResponse = new ErrorResponse(101, unfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }*/
}
