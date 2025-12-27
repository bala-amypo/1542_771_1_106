package com.example.demo.util;

public class ValidationUtil {

    public static void requireRegion(String region) {
        if (region == null || region.trim().isEmpty()) {
            throw new IllegalArgumentException("region required");
        }
    }

    public static void requireSensorType(String sensorType) {
        if (sensorType == null || sensorType.trim().isEmpty()) {
            throw new IllegalArgumentException("sensorType required");
        }
    }

    public static void validateMinMax(Double min, Double max) {
        if (min == null || max == null || min >= max) {
            throw new IllegalArgumentException("minvalue invalid");
        }
    }

    public static void requireReadingValue(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("readingvalue missing");
        }
    }
}
