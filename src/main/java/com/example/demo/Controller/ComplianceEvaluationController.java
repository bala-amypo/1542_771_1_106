package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Endpoints")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceEvaluationService;

    public ComplianceEvaluationController(ComplianceEvaluationService complianceEvaluationService) {
        this.complianceEvaluationService = complianceEvaluationService;
    }

    @PostMapping("/evaluate/{readingId}")
    @Operation(summary = "Evaluate a sensor reading")
    public ApiResponse evaluate(@PathVariable Long readingId) {
        ComplianceLog log = complianceEvaluationService.evaluateReading(readingId);
        return new ApiResponse(true, "Evaluation completed", log);
    }

    @GetMapping("/reading/{readingId}")
    @Operation(summary = "Get logs for a reading")
    public List<ComplianceLog> getLogsByReading(@PathVariable Long readingId) {
        return complianceEvaluationService.getLogsByReading(readingId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get log by ID")
    public ComplianceLog getLog(@PathVariable Long id) {
        return complianceEvaluationService.getLog(id);
    }
}
