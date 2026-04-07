package com.agriconnect.service;

import com.agriconnect.model.FarmingExpert;
import com.agriconnect.repository.FarmingExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmingExpertService {
    @Autowired
    private FarmingExpertRepository repo;

    public FarmingExpert save(FarmingExpert expert) {
        return repo.save(expert);
    }

    public List<FarmingExpert> getAll() {
        return repo.findAll();
    }
}
