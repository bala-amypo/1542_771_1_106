public interface ComplianceEvaluationService {
    ComplianceLog evaluateReading(Long readingId);
    List<ComplianceLog> getLogsByReading(Long readingId);
    ComplianceLog getLog(Long id);
}