package pl.kuba565.neo4j.transformer.dto;

import pl.kuba565.neo4j.dto.WorkerDto;
import pl.kuba565.neo4j.model.Worker;

import java.util.function.Function;

public class WorkerDtoTransformerImpl implements Function<WorkerDto, Worker> {
    private CarDtoTransformerImpl carDtoTransformerImpl;

    public WorkerDtoTransformerImpl(CarDtoTransformerImpl carDtoTransformerImpl) {
        this.carDtoTransformerImpl = carDtoTransformerImpl;
    }

    @Override
    public Worker apply(WorkerDto workerDto) {
        Worker.WorkerBuilder workerBuilder = Worker.builder()
                .id(workerDto.getId())
                .name(workerDto.getName())
                .pesel(workerDto.getPesel())
                .surname(workerDto.getSurname());
        if (workerDto.getCarDto() != null) {
            workerBuilder.car(carDtoTransformerImpl.apply(workerDto.getCarDto()));
        }
        return workerBuilder.build();
    }
}
