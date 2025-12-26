@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings Endpoints")
public class SensorReadingController {
    private final SensorReadingService readingService;

    public SensorReadingController(SensorReadingService readingService) {
        this.readingService = readingService;
    }

    @PostMapping("/{sensorId}")
    public ResponseEntity<SensorReading> submitReading(@PathVariable Long sensorId, @RequestBody SensorReading reading) {
        return ResponseEntity.ok(readingService.submitReading(sensorId, reading));
    }

    @GetMapping("/sensor/{sensorId}")
    public ResponseEntity<List<SensorReading>> getReadingsBySensor(@PathVariable Long sensorId) {
        return ResponseEntity.ok(readingService.getReadingsBySensor(sensorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorReading> getReading(@PathVariable Long id) {
        return ResponseEntity.ok(readingService.getReading(id));
    }
}