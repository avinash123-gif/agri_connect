package com.agriconnect.controller;

import com.agriconnect.model.Farmer;
import com.agriconnect.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

    @Autowired
    private FarmerService service;

    @PostMapping
    public Farmer registerFarmer(@RequestBody Farmer farmer) {
        return service.save(farmer);
    }

    @GetMapping
    public List<Farmer> getAllFarmers() {
        return service.getAll();
    }
}
