package com.example.demo.service.impl;

import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;

@Service  // This marks the class as a Spring-managed bean
public class SensorReadingServiceImpl implements SensorReadingService {

    @Override
    public void processSensorReading() {
        // Your logic to process sensor reading
        System.out.println("Processing sensor reading...");
    }
}
