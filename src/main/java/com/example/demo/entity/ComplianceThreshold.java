package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorType;
    private String severityLevel;
    private Double minValue;
    private Double maxValue;

    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // setters
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    // getters
    public String getSensorType() {
        return sensorType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }
}
