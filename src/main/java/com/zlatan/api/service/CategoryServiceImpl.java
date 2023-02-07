package com.zlatan.api.service;

import com.zlatan.api.entity.CategoryEntity;
import com.zlatan.api.model.Category;
import com.zlatan.api.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepo){
        this.categoryRepository = categoryRepo;
    }
    @Override
    public Category createCategory(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(category,categoryEntity);
        categoryRepository.save(categoryEntity);
        return category;
    }

    @Override
    public List<Category> getAllCategory() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<Category> categories = categoryEntities.stream().map(cat ->new Category(
                cat.getId(),
                cat.getName(),
                cat.getUrl(),
                cat.getIcon(),
                cat.isHighlight()
        )).collect(Collectors.toList());
        return categories;
    }

    @Override
    public boolean deleteCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        categoryRepository.delete(categoryEntity);
        return true;
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = new Category();
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        BeanUtils.copyProperties(categoryEntity,category);
        return category;
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        categoryEntity.setName(category.getName());

        categoryEntity.setUrl(category.getUrl());
        categoryEntity.setIcon(category.getIcon());
        categoryEntity.setHighlight(category.isHighlight());
        categoryRepository.save(categoryEntity);
        return category;
    }
}
