package com.example.POS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.POS.entity.OrderItem;

@Service
public interface OrderitemService {
    
    List<OrderItem> getAllProductByOrderId(Long id);
    OrderItem addOrderItemToOrder(Long orderId, Long itemId, Double quantity);
    void deleteOrderItemFromOrder(Long orderItemId);
}
