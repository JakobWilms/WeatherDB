package com.github.jakobwilms.weatherdb.we;

import com.github.jakobwilms.weatherdb.ut.TimeUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherUtils {


    private static final @NotNull ScheduledExecutorService service60 = Executors.newSingleThreadScheduledExecutor();
    private static final @NotNull ScheduledExecutorService service3600 = Executors.newSingleThreadScheduledExecutor();
    private static final @NotNull ScheduledExecutorService service86400 = Executors.newSingleThreadScheduledExecutor();
    private static final @NotNull List<SimpleWeather> simpleWeathers = new ArrayList<>();
    private static @NotNull SimpleWeather current = new SimpleWeather();
    private static boolean started = false;

    static void updateWeather() {
        // TODO
    }

    public static void start() {
        if (!started) {
            started = true;
            int sec = TimeUtils.getSecond(), min = TimeUtils.getMinute(), hour = TimeUtils.getHour();
            service60.scheduleAtFixedRate(WeRun.runnable60, 60 - sec, 60, TimeUnit.SECONDS);
            service3600.scheduleAtFixedRate(WeRun.runnable3600, 3600 - (min * 60L) - sec + 15, 3600, TimeUnit.SECONDS);
            service86400.scheduleAtFixedRate(WeRun.runnable86400, 86400 - (hour * 3600L) - (min * 60L) - sec + 60, 86400, TimeUnit.SECONDS);
        }
    }

    public static void stop() {
        service60.shutdownNow();
        service3600.shutdownNow();
        service86400.shutdownNow();
    }

    public static @NotNull SimpleWeather getCurrent() {
        return current;
    }

    public static void setCurrent(@NotNull SimpleWeather current) {
        WeatherUtils.current = current;
    }

    public static @NotNull List<SimpleWeather> getSimpleWeathers() {
        return simpleWeathers;
    }
}
