package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Category;
import com.laraferrer.wheretoeat.exception.CategoryNotFoundException;
import com.laraferrer.wheretoeat.dto.PatchDTO;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category addCategory(Category category);
    Category modifyCategory(long categoryId, Category category) throws CategoryNotFoundException;
    void patchCategory(long restaurantId, PatchDTO patchDTO) throws CategoryNotFoundException;
    void deleteCategoryById(long categoryId) throws CategoryNotFoundException;
}
