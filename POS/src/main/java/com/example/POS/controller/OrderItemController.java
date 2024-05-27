package com.example.POS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.POS.dto.OrderItemDto;
import com.example.POS.entity.OrderItem;
import com.example.POS.service.OrderitemService;

@RestController
@CrossOrigin(origins = "*")
public class OrderItemController {
    
    @Autowired
    private OrderitemService orderItemService;

    @GetMapping("/orderitems/{id}")
    public ResponseEntity<List<OrderItem>> getAllProductByOrderId(@PathVariable Long id) {
        List<OrderItem> orderItems = orderItemService.getAllProductByOrderId(id);

        if(orderItems != null){
            return ResponseEntity.status(200).body(orderItems);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/orderitems/{id}")
    public ResponseEntity<OrderItem> addOrderItemToOrder(@PathVariable Long id, @RequestBody OrderItemDto orderItemDto){
        OrderItem orderItem = orderItemService.addOrderItemToOrder(id, orderItemDto.getItemId(), orderItemDto.getOrderQty());
    
        if(orderItem != null){
            return ResponseEntity.status(201).body(orderItem);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/orderitems/{id}")
    public void deleteOrderItemFromOrder(@PathVariable Long id) {
        orderItemService.deleteOrderItemFromOrder(id);
    }
}
