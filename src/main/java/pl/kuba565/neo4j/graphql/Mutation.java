package pl.kuba565.neo4j.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import pl.kuba565.neo4j.dto.CarDto;
import pl.kuba565.neo4j.dto.WorkerDto;
import pl.kuba565.neo4j.model.Car;
import pl.kuba565.neo4j.model.Worker;
import pl.kuba565.neo4j.service.CarService;
import pl.kuba565.neo4j.service.WorkerService;
import pl.kuba565.neo4j.transformer.dto.CarDtoTransformerImpl;
import pl.kuba565.neo4j.transformer.dto.WorkerDtoTransformerImpl;
import pl.kuba565.neo4j.transformer.model.CarTransformerImpl;
import pl.kuba565.neo4j.transformer.model.WorkerTransformerImpl;

public class Mutation implements GraphQLMutationResolver {
    private CarService carService;
    private WorkerService workerService;
    private CarDtoTransformerImpl carDtoTransformer;
    private WorkerDtoTransformerImpl workerDtoTransformer;
    private CarTransformerImpl carTransformer;
    private WorkerTransformerImpl workerTransformer;

    public Mutation(CarService carService,
                    WorkerService workerService,
                    CarDtoTransformerImpl carDtoTransformer,
                    WorkerDtoTransformerImpl workerDtoTransformer,
                    CarTransformerImpl carTransformer,
                    WorkerTransformerImpl workerTransformer) {
        this.carService = carService;
        this.workerService = workerService;
        this.workerDtoTransformer = workerDtoTransformer;
        this.carDtoTransformer = carDtoTransformer;
        this.workerTransformer = workerTransformer;
        this.carTransformer = carTransformer;
    }


    public CarDto writeCarDto(CarDto carDto) {
        Car car = carService.save(carDtoTransformer.apply(carDto));
        return carTransformer.apply(car);
    }

    public WorkerDto writeWorkerDto(WorkerDto workerDto) {
        Worker worker = workerService.save(workerDtoTransformer.apply(workerDto));
        return workerTransformer.apply(worker);
    }

//    public Boolean updateCarDto(CarDto carDto) {
//        carService.update(carDtoTransformer.apply(carDto));
//        return true;
//    }
//
//    public Boolean updateWorkerDto(WorkerDto workerDto) {
//        workerService.update(workerDtoTransformer.apply(workerDto));
//        return true;
//    }
//
//    public Boolean deleteCarDto(Long id) {
//        carService.deleteById(id);
//        return true;
//    }
//
//    public Boolean deleteWorkerDto(Long id) {
//        workerService.deleteById(id);
//        return true;
//    }
}