package com.preworkspringredis.services;

import com.preworkspringredis.dto.DateValiteDto;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

@Service
public class DateValidationService {

    public DateValiteDto validateDate(String date) {
        LocalDateTime startDate = valiteDate(date);
        LocalDateTime endDate = startDate.plusDays(4);
        LocalDateTime currentDate = LocalDateTime.now();
        String startDateString = startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String endDateString = endDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        DateValiteDto dateValiteDto = new DateValiteDto();
        dateValiteDto.setStartDate(startDateString);
        dateValiteDto.setEndDate(endDateString);
        return dateValiteDto;
    }

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
