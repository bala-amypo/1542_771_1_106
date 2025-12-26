public interface ComplianceThresholdService {
    ComplianceThreshold createThreshold(ComplianceThreshold threshold);
    ComplianceThreshold getThreshold(Long id);
    ComplianceThreshold getThresholdBySensorType(String sensorType);
    List<ComplianceThreshold> getAllThresholds();
}