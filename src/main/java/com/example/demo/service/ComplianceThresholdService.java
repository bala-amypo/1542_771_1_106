package com.example.demo.service;

import com.example.demo.entity.ComplianceThreshold;
import java.util.List;
import java.util.Optional;

public interface ComplianceThresholdService {

    // Create a new threshold
    ComplianceThreshold createThreshold(ComplianceThreshold complianceThreshold);

    // Get all thresholds
    List<ComplianceThreshold> getAllThresholds();

    // Get a threshold by its ID
    Optional<ComplianceThreshold> getThreshold(Long id);
}
