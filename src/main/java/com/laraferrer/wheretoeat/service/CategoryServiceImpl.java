package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.Category;
import com.laraferrer.wheretoeat.exception.CategoryNotFoundException;
import com.laraferrer.wheretoeat.repository.CategoryRepository;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category modifyCategory(long categoryId, Category category) throws CategoryNotFoundException {
        Category newCategory = categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);
        newCategory.setId(category.getId());
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public void patchCategory(long categoryId, PatchDTO patchDTO) throws CategoryNotFoundException {
        Category newCategory = categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);
        if (patchDTO.getKey().equals("name")) {
            newCategory.setName(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("address")) {
            newCategory.setDescription(patchDTO.getValue());
        }

        categoryRepository.save(newCategory);
    }

    @Override
    public void deleteCategoryById(long categoryId) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(category);
    }
}
