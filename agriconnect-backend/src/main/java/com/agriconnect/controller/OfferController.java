package com.agriconnect.controller;

import com.agriconnect.model.Offer;
import com.agriconnect.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/offers")
public class OfferController {
    @Autowired
    private OfferService service;

    @PostMapping
    @PreAuthorize("hasRole('BUYER')")
    public Offer createOffer(@RequestBody Offer o) {
        return service.save(o);
    }

    @GetMapping("/product/{productId}")
    public List<Offer> getOffersByProduct(@PathVariable Long productId) {
        return service.getByProduct(productId);
    }

    @GetMapping("/buyer/{buyerId}")
    @PreAuthorize("hasRole('BUYER') or hasRole('ADMIN')")
    public List<Offer> getOffersByBuyer(@PathVariable Long buyerId) {
        return service.getByBuyer(buyerId);
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('FARMER') or hasRole('ADMIN')")
    public Offer updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('BUYER') or hasRole('ADMIN')")
    public void deleteOffer(@PathVariable Long id) {
        service.delete(id);
    }
}
