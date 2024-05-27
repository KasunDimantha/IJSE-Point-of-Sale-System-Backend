package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.POS.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
