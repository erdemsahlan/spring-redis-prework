package com.preworkspringredis.services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

@Service
public class DateValidationService {

    public LocalDateTime valiteDate(String day) {
        LocalDate date = LocalDate.parse(day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
                return date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay();

            case FRIDAY:
            case SATURDAY:
            case SUNDAY:
                return date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atStartOfDay();

            default:
                throw new IllegalStateException("Beklenmeyen gün değeri: " + dayOfWeek);
        }
    }
}
