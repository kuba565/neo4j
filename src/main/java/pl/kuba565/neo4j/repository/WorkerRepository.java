package pl.kuba565.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import pl.kuba565.neo4j.model.Worker;

@Repository
public interface WorkerRepository extends Neo4jRepository<Worker, Long> {
}
