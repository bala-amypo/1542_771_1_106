
package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.*;
public interface ComplianceThresholdRepository extends JpaRepository<ComplianceThreshold, Long> {
    Optional<ComplianceThreshold> findBySensorType(String type);
}