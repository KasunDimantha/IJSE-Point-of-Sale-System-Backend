package com.example.POS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.POS.dto.CategoryDto;
import com.example.POS.entity.Category;
import com.example.POS.service.CategoryService;

@RestController
@CrossOrigin(origins =  "*")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category01 = categoryService.addCategory(category);
        
        if(category01 != null){
            return ResponseEntity.status(200).body(category01);
        } else {
            return ResponseEntity.status(404).build(); // 404 Not Found
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        
        if(categories != null){
            return ResponseEntity.status(200).body(categories);
        } else {
            return ResponseEntity.status(404).build(); // 404 Not Found
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);

        if(category != null){
            return ResponseEntity.status(200).body(category);
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long id){
        Category category = new Category();

        category.setName(categoryDto.getName());

        Category category01 = categoryService.updateCategory(id, category);

        if(category01 != null){
            return ResponseEntity.status(200).body(category01);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }


}
