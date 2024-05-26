package com.example.POS.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.POS.entity.Category;
import com.example.POS.repository.CategoryRepository;
import com.example.POS.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existCategory = categoryRepository.findById(id).orElse(null);

        if (existCategory != null) {
            existCategory.setName(category.getName());
            return categoryRepository.save(existCategory);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
