public interface SensorReadingService {
    SensorReading submitReading(Long sensorId, SensorReading reading);
    SensorReading getReading(Long id);
    List<SensorReading> getReadingsBySensor(Long sensorId);
}