public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;
    private final LocationRepository locationRepository;

    public SensorServiceImpl(SensorRepository sensorRepository, LocationRepository locationRepository) {
        this.sensorRepository = sensorRepository;
        this.locationRepository = locationRepository;
    }

    public Sensor createSensor(Long locationId, Sensor sensor) {
        Location location = locationRepository.findById(locationId)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        if (sensor.getSensorType() == null || sensor.getSensorType().isEmpty()) {
            throw new IllegalArgumentException("sensorType");
        }
        sensor.setLocation(location);
        return sensorRepository.save(sensor);
    }

    public Sensor getSensor(Long id) {
        return sensorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Sensor not found"));
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}