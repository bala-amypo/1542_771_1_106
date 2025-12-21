package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings Endpoints")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    @PostMapping("/{sensorId}")
    @Operation(summary = "Submit a sensor reading")
    public ApiResponse submit(@PathVariable Long sensorId, @RequestBody SensorReading reading) {
        SensorReading saved = sensorReadingService.submitReading(sensorId, reading);
        return new ApiResponse(true, "Reading submitted successfully", saved);
    }

    @GetMapping("/sensor/{sensorId}")
    @Operation(summary = "List readings by sensor")
    public List<SensorReading> getBySensor(@PathVariable Long sensorId) {
        return sensorReadingService.getReadingsBySensor(sensorId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get reading by ID")
    public SensorReading getById(@PathVariable Long id) {
        return sensorReadingService.getReading(id);
    }
}
