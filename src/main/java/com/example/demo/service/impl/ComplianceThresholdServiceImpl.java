package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;
import com.example.demo.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {

    private final ComplianceThresholdRepository repository;

    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public ComplianceThreshold createThreshold(ComplianceThreshold threshold) {
        ValidationUtil.requireSensorType(threshold.getSensorType());
        ValidationUtil.validateMinMax(threshold.getMinValue(), threshold.getMaxValue());
        return repository.save(threshold);
    }

    @Override
    public ComplianceThreshold getThreshold(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("threshold not found"));
    }

    @Override
    public ComplianceThreshold getThresholdBySensorType(String type) {
        return repository.findBySensorType(type)
                .orElseThrow(() -> new ResourceNotFoundException("threshold not found"));
    }

    @Override
    public List<ComplianceThreshold> getAllThresholds() {
        return repository.findAll();
    }
}
