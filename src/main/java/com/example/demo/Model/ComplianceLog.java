package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_logs")
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_reading_id")
    private SensorReading sensorReading;

    @ManyToOne
    @JoinColumn(name = "threshold_id")
    private ComplianceThreshold thresholdUsed;

    private String statusAssigned;

    private String remarks;

    private LocalDateTime loggedAt;

    public ComplianceLog() {}

    public ComplianceLog(SensorReading sensorReading, ComplianceThreshold thresholdUsed, String statusAssigned, String remarks, LocalDateTime loggedAt) {
        this.sensorReading = sensorReading;
        this.thresholdUsed = thresholdUsed;
        this.statusAssigned = statusAssigned;
        this.remarks = remarks;
        this.loggedAt = loggedAt;
    }

    // Getters and setters
}
