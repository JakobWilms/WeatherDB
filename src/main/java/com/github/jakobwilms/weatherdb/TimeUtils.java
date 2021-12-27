package com.github.jakobwilms.weatherdb;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    private static final String pattern = "dd.MM.yyyy HH:mm:ss:SSS";
    private static final String pattern2 = "yyyyMMddHH";

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private static final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);

    public static @NotNull String getDate() {
        return simpleDateFormat.format(new Date());
    }

    private static @NotNull String getDate2() {
        return simpleDateFormat2.format(new Date());
    }

    public static int getYear() {
        return Integer.parseInt(getDate2().substring(0, 3));
    }

    public static int getMonth() {
        return Integer.parseInt(getDate2().substring(4, 5));
    }

    public static int getDay() {
        return Integer.parseInt(getDate2().substring(6, 7));
    }

    public static int getHour() {
        return Integer.parseInt(getDate2().substring(8, 9));
    }

    public static int getSecond() {
        return Integer.parseInt(getDate().substring(17, 18));
    }

    public static int getMinute() {
        return Integer.parseInt(getDate().substring(14, 15));
    }
}
