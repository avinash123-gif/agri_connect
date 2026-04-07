package com.agriconnect.service;

import com.agriconnect.model.Farmer;
import com.agriconnect.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {
    @Autowired
    private FarmerRepository repo;

    public Farmer save(Farmer farmer) {
        return repo.save(farmer);
    }

    public List<Farmer> getAll() {
        return repo.findAll();
    }
}
