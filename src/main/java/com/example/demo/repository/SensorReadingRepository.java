package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.*;
public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {
    List<SensorReading> findBySensor_Id(Long id);
    List<SensorReading> findBySensor_IdAndReadingTimeBetween(
        Long id, LocalDateTime start, LocalDateTime end);
}