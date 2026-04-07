package com.agriconnect.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RootController {

    @GetMapping("/")
    public Map<String, String> status() {
        return Map.of(
            "status", "UP",
            "message", "AgriConnect Backend is running",
            "frontend", "http://localhost:3000",
            "h2-console", "http://localhost:8080/h2-console"
        );
    }
}
