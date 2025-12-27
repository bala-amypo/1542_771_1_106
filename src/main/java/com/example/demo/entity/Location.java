package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String locationName;

    private String description;

    private String region;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
