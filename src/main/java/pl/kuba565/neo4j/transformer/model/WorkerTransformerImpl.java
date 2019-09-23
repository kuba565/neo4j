package pl.kuba565.neo4j.transformer.model;

import pl.kuba565.neo4j.dto.WorkerDto;
import pl.kuba565.neo4j.model.Worker;

import java.util.function.Function;

public class WorkerTransformerImpl implements Function<Worker, WorkerDto> {
    private CarTransformerImpl carTransformerImpl;

    public WorkerTransformerImpl(CarTransformerImpl carTransformerImpl) {
        this.carTransformerImpl = carTransformerImpl;
    }

    public WorkerDto apply(Worker worker) {
        WorkerDto.WorkerDtoBuilder workerDtoBuilder = WorkerDto.builder()
                .id(worker.getId())
                .name(worker.getName())
                .pesel(worker.getPesel())
                .surname(worker.getSurname());
        if (worker.getCar() != null) {
            workerDtoBuilder.carDto(carTransformerImpl.apply(worker.getCar()));
        }
        return workerDtoBuilder.build();
    }
}
