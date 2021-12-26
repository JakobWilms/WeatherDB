package com.github.jakobwilms.weatherdb;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherUtils {

    private static final ScheduledExecutorService service60 = Executors.newSingleThreadScheduledExecutor();
    private static final ScheduledExecutorService service3600 = Executors.newSingleThreadScheduledExecutor();
    private static final Runnable runnable60 = () -> {

    };
    private static final Runnable runnable3600 = () -> {

    };
    private static boolean started = false;

    public static void start() {
        if (!started) {
            started = true;
            service60.scheduleAtFixedRate(runnable60, 0L, 60, TimeUnit.SECONDS);
            service3600.scheduleAtFixedRate(runnable3600, 15L, 3600, TimeUnit.SECONDS);
        }
    }

    public static void stop() {
        service60.shutdownNow();
        service3600.shutdownNow();
    }
}
