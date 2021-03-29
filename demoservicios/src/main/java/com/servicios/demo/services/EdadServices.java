package com.servicios.demo.services;

import java.time.LocalDate;
import java.time.Period;

public class EdadServices {

    public static int convertirEdad(int day, int month, int year)
    {
        LocalDate date = LocalDate.of(year, month, day);
        Period period = Period.between(date, LocalDate.now());

        return  period.getYears();
    }
}
