package com.laraferrer.wheretoeat.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(long userId) {
        super("No se ha encontrado un usuario con la ID " + userId);
    }

    public UserNotFoundException() {
        super("Usuario no encontrado. Vuelve a hacer una nueva búsqueda");
    }
}