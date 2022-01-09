package com.github.jakobwilms.weatherdb.db;

import com.github.jakobwilms.weatherdb.ut.Date;
import com.github.jakobwilms.weatherdb.we.MinMaxMedium;
import com.github.jakobwilms.weatherdb.we.SimpleWeather;
import com.github.jakobwilms.weatherdb.we.Weather;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class DBConvert {

    @Contract("_ -> new")
    static String @NotNull [] _toString0(@NotNull Weather weather) {
        return new String[]{
                String.valueOf(weather.id()),
                String.valueOf(weather.date().year()), String.valueOf(weather.date().month()), String.valueOf(weather.date().day()), String.valueOf(weather.date().hour()),
                String.valueOf(weather.temperature().min()), String.valueOf(weather.temperature().max()), String.valueOf(weather.temperature().medium()),
                String.valueOf(weather.rainfall().min()), String.valueOf(weather.rainfall().max()), String.valueOf(weather.rainfall().medium()),
                String.valueOf(weather.humidity().min()), String.valueOf(weather.humidity().max()), String.valueOf(weather.humidity().medium()),
                String.valueOf(weather.wind().min()), String.valueOf(weather.wind().max()), String.valueOf(weather.wind().medium()),
                String.valueOf(weather.clouds().min()), String.valueOf(weather.clouds().max()), String.valueOf(weather.clouds().medium())
        };
    }

    @Contract("_ -> new")
    static @NotNull Weather _toWeather0(String @NotNull [] strings) {
        return new Weather(
                Integer.parseInt(strings[0]),
                new Date(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4])),
                new MinMaxMedium(Float.parseFloat(strings[5]), Float.parseFloat(strings[6]), Float.parseFloat(strings[7])),
                new MinMaxMedium(Float.parseFloat(strings[8]), Float.parseFloat(strings[9]), Float.parseFloat(strings[10])),
                new MinMaxMedium(Float.parseFloat(strings[11]), Float.parseFloat(strings[12]), Float.parseFloat(strings[13])),
                new MinMaxMedium(Float.parseFloat(strings[14]), Float.parseFloat(strings[15]), Float.parseFloat(strings[16])),
                new MinMaxMedium(Float.parseFloat(strings[17]), Float.parseFloat(strings[18]), Float.parseFloat(strings[19]))
        );
    }

    @Contract("_ -> new")
    static String @NotNull [] _toSimpleString0(@NotNull SimpleWeather simpleWeather) {
        return new String[]{
                String.valueOf(simpleWeather.temperature()),
                String.valueOf(simpleWeather.rainfall()),
                String.valueOf(simpleWeather.humidity()),
                String.valueOf(simpleWeather.wind()),
                String.valueOf(simpleWeather.clouds())
        };
    }

    @Contract("_ -> new")
    static @NotNull SimpleWeather _toSimpleWeather0(String @NotNull [] strings) {
        return new SimpleWeather(
                Float.parseFloat(strings[0]),
                Float.parseFloat(strings[1]),
                Float.parseFloat(strings[2]),
                Float.parseFloat(strings[3]),
                Float.parseFloat(strings[4])
        );
    }
}
