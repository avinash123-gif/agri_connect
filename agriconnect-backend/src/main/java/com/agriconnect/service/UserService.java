package com.agriconnect.service;

import com.agriconnect.model.User;
import com.agriconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User save(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }
    
    public Optional<User> getByUsername(String username) {
        return repo.findByUsername(username);
    }
}
