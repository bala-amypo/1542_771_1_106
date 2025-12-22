package com.example.demo.controller;

import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // Example API endpoint to save location
    @PostMapping("/save")
    public String saveLocation(@RequestParam String locationName) {
        locationService.saveLocation(locationName);
        return "Location saved successfully: " + locationName;
    }

    // Example API endpoint to get location by ID
    @GetMapping("/{id}")
    public String getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }
}
