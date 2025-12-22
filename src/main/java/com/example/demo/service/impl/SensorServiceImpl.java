package com.example.demo.service.impl;

import com.example.demo.service.SensorService;
import org.springframework.stereotype.Service;

@Service  // This marks the class as a Spring bean
public class SensorServiceImpl implements SensorService {
    @Override
    public void processSensorData() {
        // Implementation logic for processing sensor data
        System.out.println("Processing sensor data...");
    }
}
