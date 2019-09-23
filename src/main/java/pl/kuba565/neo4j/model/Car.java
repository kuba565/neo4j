package pl.kuba565.neo4j.model;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;
    private Integer weight;
    private Integer numberOfSeats;
    private String registrationNumber;
    @Relationship
    private Log log;

    public Car(Long id, Integer weight, Integer numberOfSeats, String registrationNumber) {
        this.id = id;
        this.weight = weight;
        this.numberOfSeats = numberOfSeats;
        this.registrationNumber = registrationNumber;
    }
}
