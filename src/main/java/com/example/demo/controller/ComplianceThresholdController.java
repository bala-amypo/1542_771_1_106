@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {
    private final ComplianceThresholdService thresholdService;

    public ComplianceThresholdController(ComplianceThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    public ResponseEntity<ComplianceThreshold> createThreshold(@RequestBody ComplianceThreshold threshold) {
        return ResponseEntity.ok(thresholdService.createThreshold(threshold));
    }

    @GetMapping
    public ResponseEntity<List<ComplianceThreshold>> getAllThresholds() {
        return ResponseEntity.ok(thresholdService.getAllThresholds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplianceThreshold> getThreshold(@PathVariable Long id) {
        return ResponseEntity.ok(thresholdService.getThreshold(id));
    }

    @GetMapping("/type/{sensorType}")
    public ResponseEntity<ComplianceThreshold> getThresholdBySensorType(@PathVariable String sensorType) {
        return ResponseEntity.ok(thresholdService.getThresholdBySensorType(sensorType));
    }
}