package com.laraferrer.wheretoeat.exception;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(long categoryId) {
        super("No se ha encontrado una categoría con la ID " + categoryId);
    }

    public CategoryNotFoundException() {
        super("Categoría no encontrada. Vuelve a hacer una nueva búsqueda");
    }
}