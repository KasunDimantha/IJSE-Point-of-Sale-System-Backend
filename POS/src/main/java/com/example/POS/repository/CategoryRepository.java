package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POS.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
