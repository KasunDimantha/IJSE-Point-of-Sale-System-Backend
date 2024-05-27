package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.POS.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
