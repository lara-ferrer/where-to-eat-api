package com.laraferrer.wheretoeat.exception;

public class RestaurantNotFoundException extends Exception {
    public RestaurantNotFoundException(String message) {
        super(message);
    }

    public RestaurantNotFoundException(long restaurantId) {
        super("No se ha encontrado un restaurante con la ID " + restaurantId);
    }

    public RestaurantNotFoundException() {
        super("Restaurante no encontrado. Vuelve a hacer una nueva búsqueda");
    }
}