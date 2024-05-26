package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POS.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
