package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.*;
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByLocationName(String name);
    List<Location> findByRegion(String region);
}