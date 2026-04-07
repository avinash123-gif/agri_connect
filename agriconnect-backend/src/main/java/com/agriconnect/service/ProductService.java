package com.agriconnect.service;

import com.agriconnect.model.Product;
import com.agriconnect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repo;

    public Product save(Product p) {
        return repo.save(p);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public List<Product> getByFarmer(String farmerName) {
        return repo.findByFarmerName(farmerName);
    }

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Product buy(Long id, int quantityToBuy) {
        Product p = repo.findById(id).orElseThrow();
        if (p.getQuantity() >= quantityToBuy) {
            p.setQuantity(p.getQuantity() - quantityToBuy);
            return repo.save(p);
        }
        return p;
    }
}
