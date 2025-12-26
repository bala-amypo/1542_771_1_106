public interface SensorService {
    Sensor createSensor(Long locationId, Sensor sensor);
    Sensor getSensor(Long id);
    List<Sensor> getAllSensors();
}