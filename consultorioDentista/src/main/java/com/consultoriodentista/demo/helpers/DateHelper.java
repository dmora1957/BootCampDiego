package com.consultoriodentista.demo.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {
    /**
     * parse a string date to a Date type
     *
     * @param stringDate string from date
     * @return a Date object
     * @throws ParseException when there is an error parsing dates
     */
    public static Date parseStringToDate(String stringDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        formatter.setLenient(false);
        return formatter.parse(stringDate);
    }
}
