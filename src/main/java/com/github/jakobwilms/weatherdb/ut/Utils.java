package com.github.jakobwilms.weatherdb.ut;

public class Utils {
    public static void print(String msg) {
        System.out.println("{" + TimeUtils.getDate() +
                ", msg: \"" + msg + "\"};");
    }
}
