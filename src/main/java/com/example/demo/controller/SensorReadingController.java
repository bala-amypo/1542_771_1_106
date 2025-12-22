package com.example.demo.controller;

import com.example.demo.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor-reading")  // Define the base URL for this controller
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    // Constructor-based dependency injection
    @Autowired
    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    // Endpoint to trigger the sensor reading process
    @GetMapping("/process")
    public String processSensorReading() {
        sensorReadingService.processSensorReading();
        return "Sensor reading processed successfully!";
    }
}
