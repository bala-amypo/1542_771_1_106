package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
public interface ComplianceThresholdService {
    ComplianceThreshold createThreshold(ComplianceThreshold threshold);
    ComplianceThreshold getThreshold(Long id);
    ComplianceThreshold getThresholdBySensorType(String type);
    List<ComplianceThreshold> getAllThresholds();
}