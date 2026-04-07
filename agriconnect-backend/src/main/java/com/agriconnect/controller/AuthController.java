package com.agriconnect.controller;

import com.agriconnect.model.User;
import com.agriconnect.payload.request.LoginRequest;
import com.agriconnect.payload.request.SignupRequest;
import com.agriconnect.payload.response.JwtResponse;
import com.agriconnect.payload.response.MessageResponse;
import com.agriconnect.repository.UserRepository;
import com.agriconnect.security.jwt.JwtUtils;
import com.agriconnect.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        
        // Check if Admin is approved
        User user = userRepository.findByUsername(userDetails.getUsername()).get();
        if (user.getRole().equals("ADMIN") && !user.isApproved()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Admin account is pending approval. Login blocked."));
        }

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        try {
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
            }

            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
            }

            // gmail-only validation
            if (!signUpRequest.getEmail().endsWith("@gmail.com")) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Only @gmail.com IDs are allowed!"));
            }

            // Create new user's account
            User user = new User();
            user.setUsername(signUpRequest.getUsername());
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(encoder.encode(signUpRequest.getPassword()));

            String strRole = signUpRequest.getRole();
            if (strRole == null) {
                user.setRole("BUYER");
            } else {
                user.setRole(strRole.toUpperCase());
            }

            // Admin Approval Logic
            if (user.getRole().equals("ADMIN")) {
                long adminCount = userRepository.countByRole("ADMIN");
                if (adminCount == 0) {
                    user.setApproved(true); // Bootstrap first admin
                } else {
                    user.setApproved(false); // New admins need approval
                }
            } else {
                user.setApproved(true); // Farmers, Experts, Buyers are auto-approved
            }

            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: " + e.getMessage()));
        }
    }
}
