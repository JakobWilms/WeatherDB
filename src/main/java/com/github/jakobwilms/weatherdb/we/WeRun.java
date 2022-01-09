package com.github.jakobwilms.weatherdb.we;

import com.github.jakobwilms.weatherdb.db.DBUtils;
import com.github.jakobwilms.weatherdb.ut.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.github.jakobwilms.weatherdb.we.MinMaxMedium.minMaxMedium;

public class WeRun {
    static final Runnable runnable60 = () -> {
        WeatherUtils.updateWeather();
        DBUtils.setTable("weatherCurrent");
        boolean deleted = DBUtils.simpleDelete();
        boolean inserted = DBUtils.simpleInsert(WeatherUtils.getCurrent());
        WeatherUtils.getSimpleWeathers().add(WeatherUtils.getCurrent());
    };

    static final Runnable runnable3600 = () -> {
        float[][] floats = new float[5][];
        IntStream.range(0, WeatherUtils.getSimpleWeathers().size()).forEach(i -> floats[0][i] = WeatherUtils.getSimpleWeathers().get(i).temperature());
        IntStream.range(0, WeatherUtils.getSimpleWeathers().size()).forEach(i -> floats[1][i] = WeatherUtils.getSimpleWeathers().get(i).rainfall());
        IntStream.range(0, WeatherUtils.getSimpleWeathers().size()).forEach(i -> floats[2][i] = WeatherUtils.getSimpleWeathers().get(i).humidity());
        IntStream.range(0, WeatherUtils.getSimpleWeathers().size()).forEach(i -> floats[3][i] = WeatherUtils.getSimpleWeathers().get(i).wind());
        IntStream.range(0, WeatherUtils.getSimpleWeathers().size()).forEach(i -> floats[4][i] = WeatherUtils.getSimpleWeathers().get(i).clouds());

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

    static final Runnable runnable86400 = () -> {
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
}
