package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String locationName;

    private String description;

    @Column(nullable = false)
    private String region;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "location")
    private List<Sensor> sensors;

    public Location() {}

    public Location(String locationName, String description, String region, LocalDateTime createdAt) {
        this.locationName = locationName;
        this.description = description;
        this.region = region;
        this.createdAt = createdAt;
    }

    // Getters and setters
}
