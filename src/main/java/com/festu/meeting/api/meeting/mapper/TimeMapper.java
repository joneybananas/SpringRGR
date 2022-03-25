package com.festu.meeting.api.meeting.mapper;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Component
public class TimeMapper {

    @Named("toLocalDateTime")
    List<LocalDateTime> toLocalDateTime(List<String> dateTimes) {
        return dateTimes.stream()
                        .map(x -> LocalDateTime.parse(x, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                        .collect(Collectors.toList());
    }

}
