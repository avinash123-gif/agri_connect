package com.agriconnect.service;

import com.agriconnect.model.Offer;
import com.agriconnect.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    @Autowired
    private OfferRepository repo;

    public Offer save(Offer o) {
        return repo.save(o);
    }

    public List<Offer> getByProduct(Long productId) {
        return repo.findByProductId(productId);
    }

    public List<Offer> getByBuyer(Long buyerId) {
        return repo.findByBuyerId(buyerId);
    }

    public Offer updateStatus(Long id, String status) {
        Offer o = repo.findById(id).orElseThrow();
        o.setStatus(status);
        return repo.save(o);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
