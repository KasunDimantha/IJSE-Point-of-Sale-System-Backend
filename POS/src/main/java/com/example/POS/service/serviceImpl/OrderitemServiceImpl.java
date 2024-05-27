package com.example.POS.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.POS.entity.Item;
import com.example.POS.entity.Order;
import com.example.POS.entity.OrderItem;
import com.example.POS.repository.ItemRepository;
import com.example.POS.repository.OrderItemRepository;
import com.example.POS.repository.OrderRepository;
import com.example.POS.service.OrderitemService;

public class OrderitemServiceImpl implements OrderitemService{
     
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderItem> getAllProductByOrderId(Order order) {
        return orderItemRepository.findByOrder(order);
    }

    @Override 
    public OrderItem addOrderItemToOrder(Long orderId, Long itemId, Double quantity){
        Order order = orderRepository.findById(orderId).orElse(null);

        if(order == null){
            return null;
        } 

        Item item = itemRepository.findById(itemId).orElse(null);

        if(item == null){
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem.setOrderQty(quantity);
        orderItem.setItemPrice(item.getPrice() * quantity);

        return orderItemRepository.save(orderItem);

    }

    @Override
    public void deleteOrderItemFromOrder(Long id){
        orderItemRepository.deleteById(id);
    }
}
