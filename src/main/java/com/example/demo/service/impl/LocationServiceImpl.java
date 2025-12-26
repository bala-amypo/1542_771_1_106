public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(Location location) {
        if (location.getRegion() == null || location.getRegion().isEmpty()) {
            throw new IllegalArgumentException("region required");
        }
        return locationRepository.save(location);
    }

    public Location getLocation(Long id) {
        return locationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}