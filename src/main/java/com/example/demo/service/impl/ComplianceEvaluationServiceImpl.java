package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.SensorReading;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;  // Add this import
import java.util.List;

@Service  // This annotation makes the class a Spring Bean
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    private final SensorReadingRepository sensorReadingRepository;
    private final ComplianceThresholdRepository thresholdRepository;
    private final ComplianceLogRepository complianceLogRepository;

    // Constructor injection
    public ComplianceEvaluationServiceImpl(SensorReadingRepository sensorReadingRepository,
                                           ComplianceThresholdRepository thresholdRepository,
                                           ComplianceLogRepository complianceLogRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.thresholdRepository = thresholdRepository;
        this.complianceLogRepository = complianceLogRepository;
    }

    @Override
    public ComplianceLog evaluateReading(Long readingId) {
        // Fetch the sensor reading
        SensorReading reading = sensorReadingRepository.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));

        // Get the threshold for the sensor's type
        String sensorType = reading.getSensor().getSensorType();
        ComplianceThreshold threshold = thresholdRepository.findBySensorType(sensorType)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        // Determine the status based on the reading value
        String statusAssigned = (reading.getReadingValue() >= threshold.getMinValue() &&
                                 reading.getReadingValue() <= threshold.getMaxValue())
                                ? "SAFE" : "UNSAFE";

        // Set the status for the reading
        reading.setStatus(statusAssigned);

        // Check if a compliance log exists for the given reading ID
        List<ComplianceLog> existingLogs = complianceLogRepository.findBySensorReading_Id(readingId);
        ComplianceLog log;
        if (!existingLogs.isEmpty()) {
            log = existingLogs.get(0);
            log.setStatusAssigned(statusAssigned);
            log.setRemarks("Updated evaluation");
            log.setLoggedAt(LocalDateTime.now());  // Using LocalDateTime to get the current time
        } else {
            // Create a new log if none exists
            log = new ComplianceLog(reading, threshold, statusAssigned,
                    "Evaluation completed", LocalDateTime.now());  // Using LocalDateTime here too
        }

        // Save and return the log
        return complianceLogRepository.save(log);
    }

    @Override
    public List<ComplianceLog> getLogsByReading(Long readingId) {
        return complianceLogRepository.findBySensorReading_Id(readingId);
    }

    @Override
    public ComplianceLog getLog(Long id) {
        return complianceLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}
