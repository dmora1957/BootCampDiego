package com.consultoriodentista.demo.helpers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DataUtils {

    public static boolean compareDate(Date start, Date end, Date date){
        return convertToLocalDateViaInstant(date).isAfter(convertToLocalDateViaInstant(start)) ||
                convertToLocalDateViaInstant(date).isEqual(convertToLocalDateViaInstant(start)) &&
                        (convertToLocalDateViaInstant(date).isBefore(convertToLocalDateViaInstant(end)) ||
                                convertToLocalDateViaInstant(date).isEqual(convertToLocalDateViaInstant(end)));
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static boolean isValid(Date date) {
        try {
            convertToLocalDateViaInstant(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}
