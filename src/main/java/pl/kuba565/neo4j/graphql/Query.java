package pl.kuba565.neo4j.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import pl.kuba565.neo4j.dto.CarDto;
import pl.kuba565.neo4j.dto.WorkerDto;
import pl.kuba565.neo4j.service.CarService;
import pl.kuba565.neo4j.service.WorkerService;
import pl.kuba565.neo4j.transformer.model.CarTransformerImpl;
import pl.kuba565.neo4j.transformer.model.WorkerTransformerImpl;

import java.util.ArrayList;
import java.util.List;

public class Query implements GraphQLQueryResolver {
    private CarService carService;
    private WorkerService workerService;
    private CarTransformerImpl carTransformer;
    private WorkerTransformerImpl workerTransformer;

    public Query(CarService carService, WorkerService workerService, CarTransformerImpl carTransformer,
                 WorkerTransformerImpl workerTransformer) {
        this.carService = carService;
        this.workerService = workerService;
        this.carTransformer = carTransformer;
        this.workerTransformer = workerTransformer;
    }


    public List<CarDto> getCarDtos() {
        List<CarDto> carDtos = new ArrayList<>();
        carService.findAll().forEach(car -> carDtos.add(carTransformer.apply(car)));
        return carDtos;
    }

    public CarDto getCarDto(Long id) {
        return carTransformer.apply(carService.findById(id).get());
    }

    public List<WorkerDto> getWorkerDtos() {
        List<WorkerDto> workerDtos = new ArrayList<>();
        workerService.findAll().forEach(worker -> workerDtos.add(workerTransformer.apply(worker)));
        return workerDtos;
    }

    public WorkerDto getWorkerDto(Long id) {
        return workerTransformer.apply(workerService.findById(id).get());
    }
}