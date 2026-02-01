// Date util
package com.procurement.procurement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    // Default date format
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    // ===================== Format Date to String =====================
    public static String formatDate(Date date) {
        return formatDate(date, DEFAULT_FORMAT);
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    // ===================== Parse String to Date =====================
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DEFAULT_FORMAT);
    }

    public static Date parseDate(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateStr);
        }
    }

    // ===================== Get Current Date =====================
    public static Date getCurrentDate() {
        return new Date();
    }
}
