public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByLocationName(String name);
    List<Location> findByRegion(String region);
}