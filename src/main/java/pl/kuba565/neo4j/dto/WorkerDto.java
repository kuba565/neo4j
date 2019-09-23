package pl.kuba565.neo4j.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerDto extends BaseDto {
    private Long id;
    private CarDto carDto;
    private String pesel;
    private String name;
    private String surname;
}
