public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {
    private final ComplianceThresholdRepository thresholdRepository;

    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }

    public ComplianceThreshold createThreshold(ComplianceThreshold threshold) {
        if (threshold.getMinValue() >= threshold.getMaxValue()) {
            throw new IllegalArgumentException("minvalue");
        }
        return thresholdRepository.save(threshold);
    }

    public ComplianceThreshold getThreshold(Long id) {
        return thresholdRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }

    public ComplianceThreshold getThresholdBySensorType(String sensorType) {
        return thresholdRepository.findBySensorType(sensorType)
            .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }

    public List<ComplianceThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }
}