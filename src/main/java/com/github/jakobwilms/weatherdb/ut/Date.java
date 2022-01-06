package com.github.jakobwilms.weatherdb.ut;

import org.jetbrains.annotations.Contract;

import static com.github.jakobwilms.weatherdb.ut.TimeUtils.*;

public record Date(int year, int month, int day, int hour) {
    public Date {
        if (year < 0 ||
                month <= 0 || month > 12 ||
                day <= 0 || day > 31
                || hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Illegal Value for Date Object!");
        }
    }

    public Date() {
        this(getYear(), getMonth(), getDay(), getHour());
    }

    @Contract(pure = true)
    @Override
    public String toString() {
        return "" + year + "-" + month + "-" + day + "-" + hour;
    }
}
