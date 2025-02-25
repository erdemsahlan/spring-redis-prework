package com.preworkspringredis.controllers;

import com.preworkspringredis.dto.DateValiteDto;
import com.preworkspringredis.dto.DayDto;
import com.preworkspringredis.services.DateValidationService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("dateValidate")
public class DateValidationController {

    private final DateValidationService dateValidationService;

    public DateValidationController(DateValidationService dateValidationService) {
        this.dateValidationService = dateValidationService;
    }

    @PostMapping("/validate")
    public DateValiteDto validate(@RequestBody DayDto day) throws ParseException {
        var test = dateValidationService.validateDate(day.getDay());
        return test;
    }
}
