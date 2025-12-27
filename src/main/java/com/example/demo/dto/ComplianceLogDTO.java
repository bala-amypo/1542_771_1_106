package com.example.demo.dto;

import java.time.LocalDateTime;

public class ComplianceLogDTO {

    private Long id;
    private String statusAssigned;
    private LocalDateTime evaluatedAt;
    private Long readingId;

    public ComplianceLogDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusAssigned() {
        return statusAssigned;
    }

    public void setStatusAssigned(String statusAssigned) {
        this.statusAssigned = statusAssigned;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }

    public Long getReadingId() {
        return readingId;
    }

    public void setReadingId(Long readingId) {
        this.readingId = readingId;
    }
}
