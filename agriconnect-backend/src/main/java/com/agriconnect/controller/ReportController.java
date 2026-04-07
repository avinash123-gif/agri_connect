package com.agriconnect.controller;

import com.agriconnect.model.Report;
import com.agriconnect.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService service;

    @PostMapping
    @PreAuthorize("hasRole('BUYER') or hasRole('FARMER')")
    public Report createReport(@RequestBody Report r) {
        return service.save(r);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Report> getAllReports() {
        return service.getAll();
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Report> getReportsByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }

    @PutMapping("/{id}/resolve")
    @PreAuthorize("hasRole('ADMIN')")
    public Report resolveReport(@PathVariable Long id) {
        return service.resolve(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteReport(@PathVariable Long id) {
        service.delete(id);
    }
}
