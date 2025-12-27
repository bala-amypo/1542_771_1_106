package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
public interface LocationService {
    Location createLocation(Location location);
    Location getLocation(Long id);
    List<Location> getAllLocations();
}