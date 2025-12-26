@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String locationName;

    private String description;

    @Column(nullable = false)
    private String region;

    private LocalDateTime createdAt;

    public Location() {}
    // Getters and setters
}