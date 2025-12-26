@Entity
@Table(name = "compliance_logs")
public class ComplianceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reading_id")
    private SensorReading sensorReading;

    @ManyToOne
    @JoinColumn(name = "threshold_id")
    private ComplianceThreshold thresholdUsed;

    private String statusAssigned;
    private String remarks;
    private LocalDateTime loggedAt;

    public ComplianceLog() {}
    // Getters and setters
}