package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sensor_readings")
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Column(nullable = false)
    private Double readingValue;

    @Column(nullable = false)
    private LocalDateTime readingTime;

    private String status;

    @OneToMany(mappedBy = "sensorReading")
    private List<ComplianceLog> logs;

    public SensorReading() {}

    public SensorReading(Sensor sensor, Double readingValue, LocalDateTime readingTime, String status) {
        this.sensor = sensor;
        this.readingValue = readingValue;
        this.readingTime = readingTime;
        this.status = status;
    }

    // Getters and setters
}
