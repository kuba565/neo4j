package pl.kuba565.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
public class Log extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
}
