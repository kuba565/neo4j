package pl.kuba565.neo4j.transformer.dto;

import pl.kuba565.neo4j.dto.LogDto;
import pl.kuba565.neo4j.model.Log;

import java.util.function.Function;

public class LogDtoTransformerImpl implements Function<LogDto, Log> {

    @Override
    public Log apply(LogDto logDto) {
        return Log.builder()
                .id(logDto.getId())
                .value(logDto.getValue())
                .build();
    }
}
