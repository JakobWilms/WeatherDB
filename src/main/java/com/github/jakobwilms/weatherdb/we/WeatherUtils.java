package com.github.jakobwilms.weatherdb.we;

import com.github.jakobwilms.weatherdb.db.DBUtils;
import com.github.jakobwilms.weatherdb.ut.TimeUtils;
import com.github.jakobwilms.weatherdb.ut.Utils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class WeatherUtils {


    private static final ScheduledExecutorService service60 = Executors.newSingleThreadScheduledExecutor();
    private static final ScheduledExecutorService service3600 = Executors.newSingleThreadScheduledExecutor();
    private static final ScheduledExecutorService service86400 = Executors.newSingleThreadScheduledExecutor();

    private static SimpleWeather current;
    private static final List<SimpleWeather> simpleWeathers = new ArrayList<>();
    private static boolean started = false;

    private static final Runnable runnable60 = () -> {
        updateWeather();
        simpleWeathers.add(current);
    };
    private static final Runnable runnable3600 = () -> {
        float[][] floats = new float[5][];
        IntStream.range(0, simpleWeathers.size()).forEach(i -> floats[0][i] = simpleWeathers.get(i).temperature());
        IntStream.range(0, simpleWeathers.size()).forEach(i -> floats[1][i] = simpleWeathers.get(i).rainfall());
        IntStream.range(0, simpleWeathers.size()).forEach(i -> floats[2][i] = simpleWeathers.get(i).humidity());
        IntStream.range(0, simpleWeathers.size()).forEach(i -> floats[3][i] = simpleWeathers.get(i).wind());
        IntStream.range(0, simpleWeathers.size()).forEach(i -> floats[4][i] = simpleWeathers.get(i).clouds());

        Weather weather = new Weather(minMaxMedium(floats[0]),
                minMaxMedium(floats[1]), minMaxMedium(floats[2]),
                minMaxMedium(floats[3]), minMaxMedium(floats[4])
        );

        Utils.print("Measured: " + weather);
        DBUtils.setTable("weatherHourly");
        boolean b = DBUtils.insert(weather);
        if (b)
            Utils.print("Successfully inserted into database!");
    };
    private static final Runnable runnable86400 = () -> {
        DBUtils.setTable("weatherHourly");

        List<Weather> weatherList = new ArrayList<>();
        int c = DBUtils.count();
        IntStream.range(0, 24).forEach(i -> weatherList.add(DBUtils.select(c - 24 + i)));

        float[][] floats = new float[5][];
        IntStream.range(0, weatherList.size()).forEach(i -> floats[0][i] = weatherList.get(i).temperature().medium());
        IntStream.range(0, weatherList.size()).forEach(i -> floats[1][i] = weatherList.get(i).rainfall().medium());
        IntStream.range(0, weatherList.size()).forEach(i -> floats[2][i] = weatherList.get(i).humidity().medium());
        IntStream.range(0, weatherList.size()).forEach(i -> floats[3][i] = weatherList.get(i).wind().medium());
        IntStream.range(0, weatherList.size()).forEach(i -> floats[4][i] = weatherList.get(i).clouds().medium());

        Weather weather = new Weather(minMaxMedium(floats[0]),
                minMaxMedium(floats[1]), minMaxMedium(floats[2]),
                minMaxMedium(floats[3]), minMaxMedium(floats[4])
        );

        Utils.print("TODAY: " + weather);
        DBUtils.setTable("weatherDaily");
        boolean b = DBUtils.insert(weather);
        if (b)
            Utils.print("Successfully inserted into database!");
        DBUtils.setTable("weatherHourly");
    };


    private static void updateWeather() {
        // TODO
    }

    @Contract("_ -> new")
    public static @NotNull MinMaxMedium minMaxMedium(float @NotNull [] values) {
        final float[] min = {Float.MAX_VALUE};
        final float[] max = {Float.MIN_VALUE};
        final float[] sum = {0};

        IntStream.range(0, values.length)
                .forEach(i -> {
                    if (values[i] < min[0]) min[0] = values[i];
                    if (values[i] > max[0]) max[0] = values[i];
                    sum[0] += values[i];
                });
        sum[0] /= values.length;
        return new MinMaxMedium(((float) Math.round(min[0]) * 100) / 100, ((float) Math.round(max[0]) * 100) / 100, ((float) Math.round(sum[0]) * 100) / 100);
    }

    public static void start() {
        if (!started) {
            started = true;
            int sec = TimeUtils.getSecond(), min = TimeUtils.getMinute(), hour = TimeUtils.getHour();
            service60.scheduleAtFixedRate(runnable60, 60 - sec, 60, TimeUnit.SECONDS);
            service3600.scheduleAtFixedRate(runnable3600, 3600 - (min * 60L) - sec + 15, 3600, TimeUnit.SECONDS);
            service86400.scheduleAtFixedRate(runnable86400, 86400 - (hour * 3600L) - (min * 60L) - sec + 60, 86400, TimeUnit.SECONDS);
        }
    }

    public static void stop() {
        service60.shutdownNow();
        service3600.shutdownNow();
    }

    public static void setCurrent(SimpleWeather current) {
        WeatherUtils.current = current;
    }
}
