package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.POS.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
