package pl.kuba565.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
public class Worker extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;
    @Relationship
    private Car car;
    private String pesel;
    private String name;
    private String surname;
}
