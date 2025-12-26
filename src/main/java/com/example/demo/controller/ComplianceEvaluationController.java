@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Endpoints")
public class ComplianceEvaluationController {
    private final ComplianceEvaluationService evaluationService;

    public ComplianceEvaluationController(ComplianceEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/evaluate/{readingId}")
    public ResponseEntity<ComplianceLog> evaluateReading(@PathVariable Long readingId) {
        return ResponseEntity.ok(evaluationService.evaluateReading(readingId));
    }

    @GetMapping("/reading/{readingId}")
    public ResponseEntity<List<ComplianceLog>> getLogsByReading(@PathVariable Long readingId) {
        return ResponseEntity.ok(evaluationService.getLogsByReading(readingId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplianceLog> getLog(@PathVariable Long id) {
        return ResponseEntity.ok(evaluationService.getLog(id));
    }
}