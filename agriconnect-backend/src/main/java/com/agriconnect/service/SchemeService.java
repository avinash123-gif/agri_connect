package com.agriconnect.service;

import com.agriconnect.model.Scheme;
import com.agriconnect.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService {
    @Autowired
    private SchemeRepository repo;

    public Scheme save(Scheme scheme) {
        return repo.save(scheme);
    }

    public List<Scheme> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
