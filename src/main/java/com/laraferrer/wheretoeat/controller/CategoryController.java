package com.laraferrer.wheretoeat.controller;

import com.laraferrer.wheretoeat.domain.Category;
import com.laraferrer.wheretoeat.dto.CategoryDTO;
import com.laraferrer.wheretoeat.dto.ErrorResponse;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import com.laraferrer.wheretoeat.exception.CategoryNotFoundException;
import com.laraferrer.wheretoeat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = null;
        categories = categoryService.findAllCategories();

        return ResponseEntity.ok(categories);
    }

    @GetMapping(value = "/category/{categoryId}")
    public ResponseEntity<CategoryDTO> getNameById(@PathVariable long categoryId) throws CategoryNotFoundException {
        CategoryDTO categoryDTO = categoryService.findNameById(categoryId);

        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category newCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping(value = "/category/{categoryId}")
    public ResponseEntity<Category> modifyCategory(@PathVariable long categoryId, @RequestBody Category category) throws CategoryNotFoundException {
        Category newCategory = categoryService.modifyCategory(categoryId, category);
        return new ResponseEntity<>(newCategory, HttpStatus.OK);
    }

    @PatchMapping(value = "/category/{categorytId}")
    public ResponseEntity<Void> patchCategory(@PathVariable long categoryId, @RequestBody PatchDTO patchDTO) throws CategoryNotFoundException {
        categoryService.patchCategory(categoryId, patchDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long categoryId) throws CategoryNotFoundException {
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(CategoryNotFoundException categoryNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(101, categoryNotFoundException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(102, "Error interno del servidor.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}