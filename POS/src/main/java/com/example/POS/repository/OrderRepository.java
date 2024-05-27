package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POS.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
