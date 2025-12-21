package com.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "compliance_logs",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "sensor_reading_id")
    }
)
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_reading_id", nullable = false, unique = true)
    private SensorReading sensorReading;

    @ManyToOne
    @JoinColumn(name = "threshold_id", nullable = false)
    private ComplianceThreshold thresholdUsed;

    @Column(name = "status_assigned", nullable = false)
    private String statusAssigned;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "logged_at", nullable = false)
    private LocalDateTime loggedAt;

    protected ComplianceLog() {
    }

    public ComplianceLog(SensorReading sensorReading,
                         ComplianceThreshold thresholdUsed,
                         String statusAssigned,
                         String remarks) {

        String evaluatedStatus = evaluateStatus(sensorReading, thresholdUsed);

        if (!evaluatedStatus.equals(statusAssigned)) {
            throw new IllegalArgumentException("statusAssigned does not match evaluated condition");
        }

        this.sensorReading = sensorReading;
        this.thresholdUsed = thresholdUsed;
        this.statusAssigned = statusAssigned;
        this.remarks = remarks;
        this.loggedAt = LocalDateTime.now();
    }

    private String evaluateStatus(SensorReading reading, ComplianceThreshold threshold) {
        Double value = reading.getReadingValue();

        if (value < threshold.getMinValue() || value > threshold.getMaxValue()) {
            return threshold.getSeverityLevel();
        }
        return "NORMAL";
    }

    public Long getId() {
        return id;
    }

    public SensorReading getSensorReading() {
        return sensorReading;
    }

    public ComplianceThreshold getThresholdUsed() {
        return thresholdUsed;
    }

    public String getStatusAssigned() {
        return statusAssigned;
    }

    public String getRemarks() {
        return remarks;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}
