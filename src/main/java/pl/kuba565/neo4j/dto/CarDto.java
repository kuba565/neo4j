package pl.kuba565.neo4j.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto extends BaseDto {
    private Long id;
    private Integer weight;
    private Integer numberOfSeats;
    private String registrationNumber;
    private LogDto logDto;
}
