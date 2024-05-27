package com.example.POS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.POS.entity.Order;
import com.example.POS.entity.OrderItem;
import java.util.List;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
    List<OrderItem> findByOrder(Order order);
}
