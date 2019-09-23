package pl.kuba565.neo4j.transformer.model;

import pl.kuba565.neo4j.dto.LogDto;
import pl.kuba565.neo4j.model.Log;

import java.util.function.Function;

public class LogTransformerImpl implements Function<Log, LogDto> {
    public LogDto apply(Log log) {
        LogDto.LogDtoBuilder logDtoBuilder = LogDto.builder();
        if (log != null) {
            logDtoBuilder.value(log.getValue());
            if (log.getId() != null) {
                logDtoBuilder.id(log.getId());
            }
            return logDtoBuilder
                    .build();
        }
        return null;
    }
}
