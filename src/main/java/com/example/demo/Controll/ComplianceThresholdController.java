package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {

    private final ComplianceThresholdService thresholdService;

    public ComplianceThresholdController(ComplianceThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    @Operation(summary = "Create a threshold")
    public ApiResponse create(@RequestBody ComplianceThreshold threshold) {
        ComplianceThreshold saved = thresholdService.createThreshold(threshold);
        return new ApiResponse(true, "Threshold created successfully", saved);
    }

    @GetMapping
    @Operation(summary = "List all thresholds")
    public List<ComplianceThreshold> getAll() {
        return thresholdService.getAllThresholds();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get threshold by ID")
    public ComplianceThreshold getById(@PathVariable Long id) {
        return thresholdService.getThreshold(id);
    }

    @GetMapping("/type/{sensorType}")
    @Operation(summary = "Get threshold by sensor type")
    public ComplianceThreshold getBySensorType(@PathVariable String sensorType) {
        return thresholdService.getThresholdBySensorType(sensorType);
    }
}
