package com.zlatan.api.service;

import com.zlatan.api.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getAllCategory();

    boolean deleteCategory(Long id);

    Category getCategoryById(Long id);

    Category updateCategory(Long id, Category category);
}
