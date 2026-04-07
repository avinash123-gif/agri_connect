package com.agriconnect.controller;

import com.agriconnect.model.User;
import com.agriconnect.payload.response.MessageResponse;
import com.agriconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/pending")
    public List<User> getPendingAdmins() {
        // Return Admins who are not yet approved
        return userRepository.findAll().stream()
                .filter(u -> u.getRole().equals("ADMIN") && !u.isApproved())
                .toList();
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<?> approveUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
        
        user.setApproved(true);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User approved successfully!"));
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
    }
}
