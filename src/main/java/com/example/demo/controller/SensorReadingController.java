package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
public class SensorReadingController {

    private final SensorReadingService readingService;

    public SensorReadingController(SensorReadingService readingService) {
        this.readingService = readingService;
    }

    @PostMapping("/sensor/{sensorId}")
    public SensorReading submitReading(
            @PathVariable Long sensorId,
            @RequestBody SensorReading reading) {
        return readingService.submitReading(sensorId, reading);
    }

    @GetMapping("/{id}")
    public SensorReading getReading(@PathVariable Long id) {
        return readingService.getReading(id);
    }

    @GetMapping("/sensor/{sensorId}")
    public List<SensorReading> getReadingsBySensor(@PathVariable Long sensorId) {
        return readingService.getReadingsBySensor(sensorId);
    }
}
