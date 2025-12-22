package com.example.demo.controller;

import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")  // Define the base URL for this controller
public class SensorController {

    private final SensorService sensorService;

    // Autowire the SensorService into the controller
    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/process")  // Endpoint to trigger the sensor data processing
    public String processSensorData() {
        sensorService.processSensorData();
        return "Sensor data processed successfully!";
    }
}
