package com.example.POS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.POS.entity.Category;

@Service
public interface CategoryService {
    
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category addCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
