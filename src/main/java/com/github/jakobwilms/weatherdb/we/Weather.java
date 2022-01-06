package com.github.jakobwilms.weatherdb.we;

import com.github.jakobwilms.weatherdb.ut.Date;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.stream.Stream;

import static com.github.jakobwilms.weatherdb.db.DBUtils.*;

public record Weather(int id, Date date,
                      MinMaxMedium temperature,
                      MinMaxMedium rainfall,
                      MinMaxMedium humidity,
                      MinMaxMedium wind,
                      MinMaxMedium clouds) {

    public Weather {
        Stream.of(date, temperature, rainfall, humidity, wind, clouds).forEach(Objects::requireNonNull);
    }

    public Weather(Date date,
                   MinMaxMedium temperature,
                   MinMaxMedium rainfall,
                   MinMaxMedium humidity,
                   MinMaxMedium wind,
                   MinMaxMedium clouds) {
        this(count(),
                date, temperature, rainfall, humidity, wind, clouds);
    }

    public Weather(MinMaxMedium temperature,
                   MinMaxMedium rainfall,
                   MinMaxMedium humidity,
                   MinMaxMedium wind,
                   MinMaxMedium clouds) {
        this(new Date(),
                temperature, rainfall, humidity, wind, clouds);
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Weather{" +
                "id: " + id +
                ", date: " + date +
                ", temperature: " + temperature.medium() +
                ", rainfall: " + rainfall.medium() +
                ", humidity: " + humidity.medium() +
                ", wind: " + wind.medium() +
                ", clouds: " + clouds.medium() +
                "}";
    }
}
