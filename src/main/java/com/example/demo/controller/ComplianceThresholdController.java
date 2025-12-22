package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/threshold")
public class ComplianceThresholdController {

    private final ComplianceThresholdService complianceThresholdService;

    @Autowired
    public ComplianceThresholdController(ComplianceThresholdService complianceThresholdService) {
        this.complianceThresholdService = complianceThresholdService;
    }

    // Create a new threshold
    @PostMapping
    public ComplianceThreshold createThreshold(@RequestBody ComplianceThreshold complianceThreshold) {
        return complianceThresholdService.createThreshold(complianceThreshold);
    }

    // Get all thresholds
    @GetMapping
    public List<ComplianceThreshold> getAllThresholds() {
        return complianceThresholdService.getAllThresholds();
    }

    // Get a threshold by ID
    @GetMapping("/{id}")
    public ComplianceThreshold getThreshold(@PathVariable Long id) {
        Optional<ComplianceThreshold> threshold = complianceThresholdService.getThreshold(id);
        if (threshold.isPresent()) {
            return threshold.get();
        } else {
            throw new RuntimeException("Threshold not found");
        }
    }
}
