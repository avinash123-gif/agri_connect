package com.agriconnect.controller;

import com.agriconnect.model.Order;
import com.agriconnect.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAll();
    }
    
    @GetMapping("/buyer/{buyerId}")
    public List<Order> getOrdersByBuyer(@PathVariable Long buyerId) {
        return service.getOrdersByBuyer(buyerId);
    }
}
