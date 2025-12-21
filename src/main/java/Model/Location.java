package com.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "locations",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "location_name")
    }
)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name", nullable = false, unique = true)
    private String locationName;

    @Column(name = "description")
    private String description;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected Location() {
    }

    public Location(String locationName, String description, String region) {
        if (region == null || region.trim().isEmpty()) {
            throw new IllegalArgumentException("region required");
        }
        this.locationName = locationName;
        this.description = description;
        this.region = region;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if (region == null || region.trim().isEmpty()) {
            throw new IllegalArgumentException("region required");
        }
        this.region = region;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
