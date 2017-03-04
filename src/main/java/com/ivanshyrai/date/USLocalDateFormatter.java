package com.ivanshyrai.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// REGION 1DATE FORMAT VALIDATION CLASS
public class USLocalDateFormatter implements Formatter<LocalDate> {
    public static final String US_PATTERN = "MM/dd/yyyy";
    public static final String NORMAL_PATTERN = "yyyy-MM-dd";

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    public static String getPattern(Locale locale) {
        return isUnitedStates(locale) ? US_PATTERN : NORMAL_PATTERN;
    }

    public static boolean isUnitedStates(Locale locale) {
//        System.out.println("US: " + Locale.US.getCountry());
//        System.out.println("Locale: " + locale.getCountry());
        return Locale.UK.getCountry().equals(locale.getCountry());

    }
}
