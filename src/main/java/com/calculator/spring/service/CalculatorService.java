package com.calculator.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class CalculatorService {

    public static final String ERROR_MASSAGE = "Ошибка при выполнении:" +
            " значение avgSalary/vacationDays введено не верно!";


    public String calculateSalary(String avgSalary,
                                  String vacationDays) {
        return calculate(avgSalary, vacationDays);
    }

    public String calculateSalary(String avgSalary, LocalDate dateStartVacation, LocalDate dateFinishVacation) {
        Long vacationDays = dateFinishVacation.toEpochDay() - dateStartVacation.toEpochDay() + 1;
        String days = vacationDays.toString();

        return calculate(avgSalary, days);
    }

    private String calculate(String avgSalary, String vacationDays) {
        long result;
        try {
            Long salary = Long.valueOf(avgSalary);
            Long days = Long.valueOf(vacationDays);

            long salaryPerDay = Math.round((salary / 29.3) * 0.87);
            result = salaryPerDay * days;
        } catch (Exception e) {
            log.error(ERROR_MASSAGE, e);
            return ERROR_MASSAGE + String.format(" Проверте введенные значения: первое - %s, второе - %s", avgSalary, vacationDays);
        }
        return Long.toString(result);
    }
}
