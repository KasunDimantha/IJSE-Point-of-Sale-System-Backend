package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POS.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
