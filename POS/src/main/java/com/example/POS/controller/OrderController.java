package com.example.POS.controller;

import java.time.LocalDateTime;
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

import com.example.POS.dto.OrderDto;
import com.example.POS.entity.Order;
import com.example.POS.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        
        if(orders != null) {
            return ResponseEntity.status(200).body(orders);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        
        if(order != null) {
            return ResponseEntity.status(200).body(order);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder() {
        Order order = new Order();

        order.setTotalPrice(0.0);
        order.setOrderDate(LocalDateTime.now());

        Order newOrder = orderService.createOrder(order);

        if(newOrder != null) {
            return ResponseEntity.status(201).body(newOrder);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        
        Order order = new Order();

        order.setTotalPrice(orderDto.getTotalPrice());

        Order updatedOrder = orderService.updateOrder(id, order);

        if(updatedOrder != null) {
            return ResponseEntity.status(200).body(updatedOrder);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
