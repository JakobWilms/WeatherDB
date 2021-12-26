package com.github.jakobwilms.weatherdb;

import java.util.Objects;
import java.util.stream.Stream;

import static com.github.jakobwilms.weatherdb.DBUtils.*;

public record Weather(int id, Date date,
                      MinMaxMedium<Integer> temperature,
                      MinMaxMedium<Double> rainfall,
                      MinMaxMedium<Double> humidity,
                      MinMaxMedium<Integer> wind,
                      MinMaxMedium<Double> clouds) {

    public Weather {
        Stream.of(date, temperature, rainfall, humidity, wind, clouds).forEach(Objects::requireNonNull);
    }

    public Weather(Date date,
                   MinMaxMedium<Integer> temperature,
                   MinMaxMedium<Double> rainfall,
                   MinMaxMedium<Double> humidity,
                   MinMaxMedium<Integer> wind,
                   MinMaxMedium<Double> clouds) {
        this(count(),
                date, temperature, rainfall, humidity, wind, clouds);
    }
}
