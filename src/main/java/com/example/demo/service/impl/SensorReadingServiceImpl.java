public class SensorReadingServiceImpl implements SensorReadingService {
    private final SensorReadingRepository readingRepository;
    private final SensorRepository sensorRepository;

    public SensorReadingServiceImpl(SensorReadingRepository readingRepository, SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }

    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        Sensor sensor = sensorRepository.findById(sensorId)
            .orElseThrow(() -> new ResourceNotFoundException("Sensor not found"));

        if (reading.getReadingValue() == null || reading.getReadingValue() == 0.0) {
            throw new IllegalArgumentException("readingvalue");
        }

        if (reading.getReadingTime() != null && reading.getReadingTime().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("reading time cannot be in future");
        }

        reading.setSensor(sensor);
        reading.setStatus("PENDING");
        return readingRepository.save(reading);
    }

    public SensorReading getReading(Long id) {
        return readingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));
    }

    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return readingRepository.findBySensor_Id(sensorId);
    }
}