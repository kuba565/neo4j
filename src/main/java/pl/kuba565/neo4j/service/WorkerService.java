package pl.kuba565.neo4j.service;

import org.springframework.stereotype.Service;
import pl.kuba565.neo4j.model.Worker;
import pl.kuba565.neo4j.repository.WorkerRepository;

import java.util.Optional;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Iterable<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Optional<Worker> findById(Long id) {
        return workerRepository.findById(id);
    }

    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }
}
