package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sensorCode;

    @Column(nullable = false)
    private String sensorType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalDateTime installedAt;

    private Boolean isActive = true;

    @OneToMany(mappedBy = "sensor")
    private List<SensorReading> readings;

    public Sensor() {}

    public Sensor(String sensorCode, String sensorType, Location location, LocalDateTime installedAt, Boolean isActive) {
        this.sensorCode = sensorCode;
        this.sensorType = sensorType;
        this.location = location;
        this.installedAt = installedAt;
        this.isActive = isActive;
    }

    // Getters and setters
}
