package fr.mariech.facturier.util;

import java.time.LocalDateTime;

public class Date {

    public static String parseDate(LocalDateTime date) {
        int year = date.getYear();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        return day + "/" + month + "/" + year;
    }
}
