package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors Endpoints")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/{locationId}")
    @Operation(summary = "Create a sensor for a location")
    public ApiResponse create(@PathVariable Long locationId, @RequestBody Sensor sensor) {
        Sensor saved = sensorService.createSensor(locationId, sensor);
        return new ApiResponse(true, "Sensor created successfully", saved);
    }

    @GetMapping
    @Operation(summary = "List all sensors")
    public List<Sensor> getAll() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get sensor by ID")
    public Sensor getById(@PathVariable Long id) {
        return sensorService.getSensor(id);
    }
}
