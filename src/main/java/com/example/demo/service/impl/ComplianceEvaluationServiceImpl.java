package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    private final SensorReadingRepository readingRepository;
    private final ComplianceThresholdRepository thresholdRepository;
    private final ComplianceLogRepository logRepository;

    public ComplianceEvaluationServiceImpl(
            SensorReadingRepository readingRepository,
            ComplianceThresholdRepository thresholdRepository,
            ComplianceLogRepository logRepository) {
        this.readingRepository = readingRepository;
        this.thresholdRepository = thresholdRepository;
        this.logRepository = logRepository;
    }

    @Override
    public ComplianceLog evaluateReading(Long readingId) {

        SensorReading reading = readingRepository.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("reading not found"));

        ComplianceThreshold threshold = thresholdRepository
                .findBySensorType(reading.getSensor().getSensorType())
                .orElseThrow(() -> new ResourceNotFoundException("threshold not found"));

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);

        if (reading.getReadingValue() < threshold.getMinValue() ||
            reading.getReadingValue() > threshold.getMaxValue()) {
            log.setStatusAssigned("NON_COMPLIANT");
            reading.setStatus("NON_COMPLIANT");
        } else {
            log.setStatusAssigned("COMPLIANT");
            reading.setStatus("COMPLIANT");
        }

        readingRepository.save(reading);
        return logRepository.save(log);
    }

    @Override
    public List<ComplianceLog> getLogsByReading(Long readingId) {
        return logRepository.findBySensorReading_Id(readingId);
    }

    @Override
    public ComplianceLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("log not found"));
    }
}
