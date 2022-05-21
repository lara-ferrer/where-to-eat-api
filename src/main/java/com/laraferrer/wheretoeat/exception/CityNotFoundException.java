package com.laraferrer.wheretoeat.exception;

public class CityNotFoundException extends Exception {
    public CityNotFoundException(String message) {
        super(message);
    }

    public CityNotFoundException(long cityId) {
        super("No se ha encontrado una ciudad con la ID " + cityId);
    }

    public CityNotFoundException() {
        super("Ciudad no encontrada. Vuelve a hacer una nueva búsqueda");
    }
}