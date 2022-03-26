package com.festu.meeting.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Component
public class LocalDateTimeConfig implements Converter<String, LocalDateTime> {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public LocalDateTime convert(String s) {
        return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
    }

}
