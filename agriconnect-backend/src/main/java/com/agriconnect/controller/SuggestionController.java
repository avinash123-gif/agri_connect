package com.agriconnect.controller;

import com.agriconnect.model.Suggestion;
import com.agriconnect.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    @Autowired
    private SuggestionService service;

    @PostMapping
    @PreAuthorize("hasRole('EXPERT') or hasRole('ADMIN')")
    public Suggestion postSuggestion(@RequestBody Suggestion s) {
        return service.save(s);
    }

    @GetMapping
    public List<Suggestion> getAllSuggestions() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EXPERT')")
    public void deleteSuggestion(@PathVariable Long id) {
        service.delete(id);
    }
}
