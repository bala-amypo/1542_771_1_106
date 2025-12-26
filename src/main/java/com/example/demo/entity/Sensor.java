@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sensorCode;

    @Column(nullable = false)
    private String sensorType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalDateTime installedAt;

    private Boolean isActive = true;

    public Sensor() {}
    // Getters and setters
}