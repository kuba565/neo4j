package pl.kuba565.neo4j.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kuba565.neo4j.service.CarService;
import pl.kuba565.neo4j.service.WorkerService;
import pl.kuba565.neo4j.transformer.dto.CarDtoTransformerImpl;
import pl.kuba565.neo4j.transformer.dto.WorkerDtoTransformerImpl;
import pl.kuba565.neo4j.transformer.model.CarTransformerImpl;
import pl.kuba565.neo4j.transformer.model.WorkerTransformerImpl;

@Configuration
public class GraphqlConfig {
    @Bean
    public Query query(CarService carService, WorkerService workerService, CarTransformerImpl carTransformer,
                       WorkerTransformerImpl workerTransformer) {
        return new Query(carService, workerService, carTransformer, workerTransformer);
    }

    @Bean
    public Mutation mutation(CarService carService,
                             WorkerService workerService,
                             CarDtoTransformerImpl carDtoTransformer,
                             WorkerDtoTransformerImpl workerDtoTransformer,
                             CarTransformerImpl carTransformer,
                             WorkerTransformerImpl workerTransformer) {
        return new Mutation(carService, workerService, carDtoTransformer, workerDtoTransformer, carTransformer, workerTransformer);
    }
}
