package com.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "sensors",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "sensor_code")
    }
)
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_code", nullable = false, unique = true)
    private String sensorCode;

    @Column(name = "sensor_type", nullable = false)
    private String sensorType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "installed_at")
    private LocalDateTime installedAt;

    @Column(name = "is_active")
    private Boolean isActive = true;

    protected Sensor() {
    }

    public Sensor(String sensorCode, String sensorType, Location location, LocalDateTime installedAt) {
        if (sensorType == null || sensorType.trim().isEmpty()) {
            throw new IllegalArgumentException("sensorType is required");
        }
        this.sensorCode = sensorCode;
        this.sensorType = sensorType;
        this.location = location;
        this.installedAt = installedAt;
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public String getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        if (sensorType == null || sensorType.trim().isEmpty()) {
            throw new IllegalArgumentException("sensorType is required");
        }
        this.sensorType = sensorType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getInstalledAt() {
        return installedAt;
    }

    public void setInstalledAt(LocalDateTime installedAt) {
        this.installedAt = installedAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}