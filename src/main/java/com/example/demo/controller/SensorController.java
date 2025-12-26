@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors Endpoints")
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/{locationId}")
    public ResponseEntity<Sensor> createSensor(@PathVariable Long locationId, @RequestBody Sensor sensor) {
        return ResponseEntity.ok(sensorService.createSensor(locationId, sensor));
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> getAllSensors() {
        return ResponseEntity.ok(sensorService.getAllSensors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensor(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.getSensor(id));
    }
}