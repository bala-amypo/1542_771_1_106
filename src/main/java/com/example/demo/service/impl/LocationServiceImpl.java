public interface LocationService {
    Location createLocation(Location location);
    Location getLocation(Long id);
    List<Location> getAllLocations();
}