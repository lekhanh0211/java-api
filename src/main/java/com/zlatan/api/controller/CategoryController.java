package com.zlatan.api.controller;

import com.zlatan.api.model.Category;
import com.zlatan.api.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private final CategoryService categoryService;
    public  CategoryController(CategoryService cateService){
        this.categoryService = cateService;
    }
    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return  categoryService.getAllCategory();
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Category category = null;
        category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category){
       category = categoryService.updateCategory(id,category);
        return ResponseEntity.ok(category);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCategory(@PathVariable Long id){
        boolean bl = false;
        bl = categoryService.deleteCategory(id);
        Map<String,Boolean> res = new HashMap<>();
        res.put("Đã xóa",bl);
        return ResponseEntity.ok(res);
    }
}
