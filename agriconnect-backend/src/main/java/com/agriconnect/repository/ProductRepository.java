package com.agriconnect.repository;

import com.agriconnect.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByFarmerName(String farmerName);
    List<Product> findByCategory(String category);
}
