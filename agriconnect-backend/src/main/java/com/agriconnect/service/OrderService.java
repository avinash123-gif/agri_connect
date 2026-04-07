package com.agriconnect.service;

import com.agriconnect.model.Order;
import com.agriconnect.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public Order save(Order order) {
        return repo.save(order);
    }

    public List<Order> getAll() {
        return repo.findAll();
    }
    
    public List<Order> getOrdersByBuyer(Long buyerId) {
        return repo.findByBuyerId(buyerId);
    }
}
