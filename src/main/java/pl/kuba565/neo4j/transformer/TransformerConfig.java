package pl.kuba565.neo4j.transformer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kuba565.neo4j.transformer.dto.CarDtoTransformerImpl;
import pl.kuba565.neo4j.transformer.dto.LogDtoTransformerImpl;
import pl.kuba565.neo4j.transformer.dto.WorkerDtoTransformerImpl;
import pl.kuba565.neo4j.transformer.model.CarTransformerImpl;
import pl.kuba565.neo4j.transformer.model.LogTransformerImpl;
import pl.kuba565.neo4j.transformer.model.WorkerTransformerImpl;

@Configuration
public class TransformerConfig {

    @Bean
    public CarDtoTransformerImpl carDtoToCarTransformerImpl(LogDtoTransformerImpl logDtoTransformerImpl) {
        return new CarDtoTransformerImpl(logDtoTransformerImpl);
    }

    @Bean
    public CarTransformerImpl carToCarDtoTransformerImpl(LogTransformerImpl logToLogDtoTransformerImpl) {
        return new CarTransformerImpl(logToLogDtoTransformerImpl);
    }

    @Bean
    public LogDtoTransformerImpl logDtoToLogTransformerImpl() {
        return new LogDtoTransformerImpl();
    }

    @Bean
    public LogTransformerImpl logToLogDtoTransformerImpl() {
        return new LogTransformerImpl();
    }

    @Bean
    public WorkerDtoTransformerImpl workerDtoToWorkerTransformerImpl(CarDtoTransformerImpl carDtoTransformerImpl) {
        return new WorkerDtoTransformerImpl(carDtoTransformerImpl);
    }

    @Bean
    public WorkerTransformerImpl workerToWorkerDtoTransformerImpl(CarTransformerImpl carTransformerImpl) {
        return new WorkerTransformerImpl(carTransformerImpl);
    }
}
