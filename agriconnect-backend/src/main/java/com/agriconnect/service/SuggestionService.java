package com.agriconnect.service;

import com.agriconnect.model.Suggestion;
import com.agriconnect.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionService {
    @Autowired
    private SuggestionRepository repo;

    public Suggestion save(Suggestion s) {
        return repo.save(s);
    }

    public List<Suggestion> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
