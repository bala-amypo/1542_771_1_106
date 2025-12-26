@Entity
@Table(name = "compliance_thresholds")
public class ComplianceThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sensorType;

    private Double minValue;
    private Double maxValue;

    @Column(nullable = false)
    private String severityLevel;

    private LocalDateTime createdAt;

    public ComplianceThreshold() {}
    // Getters and setters
}