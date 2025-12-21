package com.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_readings")
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @Column(name = "reading_value", nullable = false)
    private Double readingValue;

    @Column(name = "reading_time", nullable = false)
    private LocalDateTime readingTime;

    @Column(name = "status")
    private String status;

    protected SensorReading() {
    }

    public SensorReading(Sensor sensor, Double readingValue, LocalDateTime readingTime, ComplianceThreshold threshold) {
        if (readingValue == null) {
            throw new IllegalArgumentException("readingvalue is required");
        }
        if (readingTime != null && readingTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("readingTime cannot be future");
        }

        this.sensor = sensor;
        this.readingValue = readingValue;
        this.readingTime = readingTime != null ? readingTime : LocalDateTime.now();
        this.status = determineStatus(readingValue, threshold);
    }

    private String determineStatus(Double value, ComplianceThreshold threshold) {
        if (threshold == null) {
            return "UNKNOWN";
        }
        if (value < threshold.getMinValue() || value > threshold.getMaxValue()) {
            return threshold.getSeverityLevel();
        }
        return "NORMAL";
    }

    public Long getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(Double readingValue) {
        if (readingValue == null) {
            throw new IllegalArgumentException("readingvalue is required");
        }
        this.readingValue = readingValue;
    }

    public LocalDateTime getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(LocalDateTime readingTime) {
        if (readingTime != null && readingTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("readingTime cannot be future");
        }
        this.readingTime = readingTime;
    }

    public String getStatus() {
        return status;
    }
}
