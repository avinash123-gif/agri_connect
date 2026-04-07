package com.agriconnect.controller;

import com.agriconnect.model.Scheme;
import com.agriconnect.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    @Autowired
    private SchemeService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Scheme addScheme(@RequestBody Scheme scheme) {
        return service.save(scheme);
    }

    @GetMapping
    public List<Scheme> getAllSchemes() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteScheme(@PathVariable Long id) {
        service.delete(id);
    }
}
