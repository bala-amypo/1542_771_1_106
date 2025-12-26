@Entity
@Table(name = "sensor_readings")
public class SensorReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Column(nullable = false)
    private Double readingValue;

    private LocalDateTime readingTime;

    private String status;

    public SensorReading() {}
    // Getters and setters
}