package com.example.demo.service;

import com.example.demo.entity.ComplianceThreshold;

import java.util.Optional;

public interface ComplianceThresholdService {
    Optional<ComplianceThreshold> getThresholdBySensorType(String sensorType);
}
