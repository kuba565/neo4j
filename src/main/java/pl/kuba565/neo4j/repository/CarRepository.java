package pl.kuba565.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import pl.kuba565.neo4j.model.Car;

import java.util.Optional;

@Repository
public interface CarRepository extends Neo4jRepository<Car, Long> {
    @Query("MATCH (n:`Car`) WHERE ID(n) = { id } WITH n RETURN n")
    Optional<Car> findCarByIdWithoutLog(Long id);
}
