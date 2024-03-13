package com.aredu.secretaria.libs;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
public class AgeCalculatorService {

    public int calculateAgeInMonths(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);

        int years = period.getYears();
        int months = period.getMonths();
        int totalMonths = years * 12 + months;

        return totalMonths;
    }
}

