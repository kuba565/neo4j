package pl.kuba565.neo4j.transformer.dto;

import pl.kuba565.neo4j.dto.CarDto;
import pl.kuba565.neo4j.model.Car;

import java.util.function.Function;

public class CarDtoTransformerImpl implements Function<CarDto, Car> {
    private LogDtoTransformerImpl logDtoTransformerImpl;

    public CarDtoTransformerImpl(LogDtoTransformerImpl logDtoTransformerImpl) {
        this.logDtoTransformerImpl = logDtoTransformerImpl;
    }

    @Override
    public Car apply(CarDto carDto) {
        Car.CarBuilder carBuilder = Car.builder()
                .id(carDto.getId())
                .registrationNumber(carDto.getRegistrationNumber())
                .weight(carDto.getWeight())
                .numberOfSeats(carDto.getNumberOfSeats());
        if (carDto.getLogDto() != null) {
            carBuilder.log(logDtoTransformerImpl.apply(carDto.getLogDto()));
        }
        return carBuilder.build();
    }
}
