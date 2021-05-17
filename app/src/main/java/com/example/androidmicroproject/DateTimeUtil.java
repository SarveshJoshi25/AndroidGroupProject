package com.example.androidmicroproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

    public static String formatDate(GregorianCalendar calendar) {
        return dateFormat.format(calendar.getTime());
    }

    public static GregorianCalendar parseDate(String date) {
        try {
            Date parsedDate = dateFormat.parse(date);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(parsedDate);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a", Locale.US);

    public static String formatTime(GregorianCalendar calendar) {
        return timeFormat.format(calendar.getTime());
    }

    public static GregorianCalendar parseTime(String time) {
        try {
            Date parsedTime = timeFormat.parse(time);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(parsedTime);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
