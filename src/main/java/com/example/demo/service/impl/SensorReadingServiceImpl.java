package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorReadingService;
import com.example.demo.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;
    private final SensorRepository sensorRepository;
    private final ComplianceLogRepository complianceLogRepository;

    // ✅ USED BY TESTS
    public SensorReadingServiceImpl(
            SensorReadingRepository sensorReadingRepository,
            SensorRepository sensorRepository) {

        this.sensorReadingRepository = sensorReadingRepository;
        this.sensorRepository = sensorRepository;
        this.complianceLogRepository = null;
    }

    // ✅ USED BY SPRING (IMPORTANT)
    @Autowired
    public SensorReadingServiceImpl(
            SensorReadingRepository sensorReadingRepository,
            SensorRepository sensorRepository,
            ComplianceLogRepository complianceLogRepository) {

        this.sensorReadingRepository = sensorReadingRepository;
        this.sensorRepository = sensorRepository;
        this.complianceLogRepository = complianceLogRepository;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {

        ValidationUtil.requireReadingValue(reading.getReadingValue());

        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("sensor not found"));

        reading.setSensor(sensor);
        SensorReading saved = sensorReadingRepository.save(reading);

        if (complianceLogRepository != null) {
            ComplianceLog log = new ComplianceLog();
            log.setSensorReading(saved);
            log.setStatusAssigned("EVALUATED");
            complianceLogRepository.save(log);
        }

        return saved;
    }

    @Override
    public SensorReading submitReading(SensorReading reading) {

        ValidationUtil.requireReadingValue(reading.getReadingValue());

        SensorReading saved = sensorReadingRepository.save(reading);

        if (complianceLogRepository != null) {
            ComplianceLog log = new ComplianceLog();
            log.setSensorReading(saved);
            log.setStatusAssigned("EVALUATED");
            complianceLogRepository.save(log);
        }

        return saved;
    }

    @Override
    public SensorReading getReading(Long id) {
        return sensorReadingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("reading not found"));
    }

    @Override
    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return sensorReadingRepository.findBySensor_Id(sensorId);
    }
}
