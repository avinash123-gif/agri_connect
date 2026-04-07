package com.agriconnect.controller;

import com.agriconnect.model.Product;
import com.agriconnect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    @PreAuthorize("hasRole('FARMER') or hasRole('ADMIN')")
    public Product addProduct(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAll();
    }

    @GetMapping("/farmer/{name}")
    @PreAuthorize("hasRole('FARMER') or hasRole('ADMIN')")
    public List<Product> getFarmerProducts(@PathVariable String name) {
        return service.getByFarmer(name);
    }

    @GetMapping("/category/{cat}")
    public List<Product> getByCategory(@PathVariable String cat) {
        return service.getByCategory(cat);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('FARMER') or hasRole('ADMIN')")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/{id}/buy")
    @PreAuthorize("hasRole('BUYER')")
    public Product buyProduct(@PathVariable Long id, @RequestParam int quantity) {
        return service.buy(id, quantity);
    }
}
