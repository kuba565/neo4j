package pl.kuba565.neo4j.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogDto extends BaseDto {
    private Long id;
    private String value;
}
