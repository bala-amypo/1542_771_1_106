package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Locations Endpoints")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    @Operation(summary = "Create a new location")
    public ApiResponse create(@RequestBody Location location) {
        Location saved = locationService.createLocation(location);
        return new ApiResponse(true, "Location created successfully", saved);
    }

    @GetMapping
    @Operation(summary = "List all locations")
    public List<Location> getAll() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get location by ID")
    public Location getById(@PathVariable Long id) {
        return locationService.getLocation(id);
    }
}
