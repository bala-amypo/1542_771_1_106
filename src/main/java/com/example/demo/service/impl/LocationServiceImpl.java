package com.example.demo.service.impl;

import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    // Example implementation of the methods
    @Override
    public void saveLocation(String locationName) {
        // Save the location logic
        System.out.println("Location saved: " + locationName);
    }

    @Override
    public String getLocation(Long locationId) {
        // Retrieve location by ID logic (dummy data)
        return "Location with ID: " + locationId;
    }
}
