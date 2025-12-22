package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {

    private final ComplianceThresholdRepository complianceThresholdRepository;

    // Constructor injection of the repository
    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository complianceThresholdRepository) {
        this.complianceThresholdRepository = complianceThresholdRepository;
    }

    @Override
    public ComplianceThreshold createThreshold(ComplianceThreshold complianceThreshold) {
        return complianceThresholdRepository.save(complianceThreshold);
    }

    @Override
    public List<ComplianceThreshold> getAllThresholds() {
        return complianceThresholdRepository.findAll();
    }

    @Override
    public Optional<ComplianceThreshold> getThreshold(Long id) {
        return complianceThresholdRepository.findById(id);
    }
}
