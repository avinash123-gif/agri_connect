package com.agriconnect.controller;

import com.agriconnect.model.FarmingExpert;
import com.agriconnect.service.FarmingExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experts")
public class FarmingExpertController {

    @Autowired
    private FarmingExpertService service;

    @PostMapping
    public FarmingExpert addExpertProfile(@RequestBody FarmingExpert expert) {
        return service.save(expert);
    }

    @GetMapping
    public List<FarmingExpert> getAllExperts() {
        return service.getAll();
    }
}
