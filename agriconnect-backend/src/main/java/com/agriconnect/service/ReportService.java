package com.agriconnect.service;

import com.agriconnect.model.Report;
import com.agriconnect.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository repo;

    public Report save(Report r) {
        return repo.save(r);
    }

    public List<Report> getAll() {
        return repo.findAll();
    }

    public List<Report> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    public Report resolve(Long id) {
        Report r = repo.findById(id).orElseThrow();
        r.setStatus("RESOLVED");
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
