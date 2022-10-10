package com.calculator.spring.controller;


import com.calculator.spring.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calcService;


    @GetMapping("/{avgSalary}/{vacationDays}")
    public ResponseEntity<String> calculate(@PathVariable("avgSalary") String avgSalary,
                                       @PathVariable("vacationDays") String vacationDays) {
        String result = calcService.calculateSalary(avgSalary, vacationDays);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{avgSalary}/{dateStartVacation}/{dateFinishVacation}")
    public ResponseEntity<String> calculate(@PathVariable("avgSalary") String avgSalary,
                                       @PathVariable("dateStartVacation") LocalDate dateStartVacation,
                                       @PathVariable("dateFinishVacation") LocalDate dateFinishVacation) {
        String result = calcService.calculateSalary(avgSalary, dateStartVacation, dateFinishVacation);
        return ResponseEntity.ok(result);
    }
}

