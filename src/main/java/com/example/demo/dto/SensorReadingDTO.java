package com.example.demo.dto;

import java.time.LocalDateTime;

public class SensorReadingDTO {

    private Long id;
    private Double readingValue;
    private String status;
    private LocalDateTime recordedAt;
    private Long sensorId;

    public SensorReadingDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(Double readingValue) {
        this.readingValue = readingValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }
}
