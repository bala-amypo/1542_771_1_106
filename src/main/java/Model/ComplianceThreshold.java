package com.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "compliance_thresholds",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "sensor_type")
    }
)
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_type", nullable = false, unique = true)
    private String sensorType;

    @Column(name = "min_value", nullable = false)
    private Double minValue;

    @Column(name = "max_value", nullable = false)
    private Double maxValue;

    @Column(name = "severity_level", nullable = false)
    private String severityLevel;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected ComplianceThreshold() {
    }

    public ComplianceThreshold(String sensorType, Double minValue, Double maxValue, String severityLevel) {
        if (severityLevel == null || severityLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("severityLevel is required");
        }
        if (minValue == null || maxValue == null || minValue >= maxValue) {
            throw new IllegalArgumentException("minvalue must be less than maxvalue");
        }
        this.sensorType = sensorType;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.severityLevel = severityLevel;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        if (minValue == null || this.maxValue == null || minValue >= this.maxValue) {
            throw new IllegalArgumentException("minvalue must be less than maxvalue");
        }
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        if (this.minValue == null || maxValue == null || this.minValue >= maxValue) {
            throw new IllegalArgumentException("minvalue must be less than maxvalue");
        }
        this.maxValue = maxValue;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        if (severityLevel == null || severityLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("severityLevel is required");
        }
        this.severityLevel = severityLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
