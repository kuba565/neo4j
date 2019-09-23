package pl.kuba565.neo4j.transformer.model;

import pl.kuba565.neo4j.dto.CarDto;
import pl.kuba565.neo4j.model.Car;

import java.util.function.Function;

public class CarTransformerImpl implements Function<Car, CarDto> {
    private LogTransformerImpl logToLogDtoTransformerImpl;

    public CarTransformerImpl(LogTransformerImpl logToLogDtoTransformerImpl) {
        this.logToLogDtoTransformerImpl = logToLogDtoTransformerImpl;
    }

    @Override
    public CarDto apply(Car car) {
        CarDto.CarDtoBuilder carDtoBuilder = CarDto.builder()
                .id(car.getId())
                .registrationNumber(car.getRegistrationNumber())
                .weight(car.getWeight())
                .numberOfSeats(car.getNumberOfSeats());
        if (car.getLog() != null) {
            carDtoBuilder.logDto(logToLogDtoTransformerImpl.apply(car.getLog()));
        }
        return carDtoBuilder.build();
    }
}
