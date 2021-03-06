package com.github.jakobwilms.weatherdb.db;

import com.github.jakobwilms.weatherdb.we.SimpleWeather;
import com.github.jakobwilms.weatherdb.we.Weather;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static com.github.jakobwilms.weatherdb.ut.Utils.print;
import static com.github.jakobwilms.weatherdb.db.DBUtils.*;

public class DBInsert {

    static boolean insertAll0(Weather @NotNull ... weathers) {
        AtomicBoolean b = new AtomicBoolean(true);
        IntStream.range(0, weathers.length)
                .forEach(i -> b.set(_insert(weathers[i], false)));

        print("Successfully inserted all elements!");
        return b.get();
    }

    static boolean _insert0(@NotNull Weather weather, boolean verbose) {
        String[] strings = _toString(weather);
        AtomicBoolean success = new AtomicBoolean(true);

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + getTable() +
                    " (id, " +
                    "year, month, day, hour, " +
                    "temperatureMin, temperatureMax, temperatureMedium, " +
                    "rainfallMin, rainfallMax, rainfallMedium, " +
                    "humidityMin, humidityMax, humidityMedium, " +
                    "windMin, windMax, windMedium, " +
                    "cloudsMin, cloudsMax, cloudsMedium) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            IntStream.range(1, strings.length + 1)
                    .forEach(i -> {
                        try {
                            statement.setString(i, strings[i - 1]);
                        } catch (SQLException e) {
                            e.printStackTrace();
                            success.set(false);
                        }
                    });

            statement.executeUpdate();

            if (verbose) print("Successfully inserted element " + weather.id() + "!");
        } catch (SQLException e) {
            print("Couldn't insert element " + weather.id() + ":");
            e.printStackTrace();
            success.set(false);
        }

        return success.get();
    }

    static boolean simpleInsert0(@NotNull SimpleWeather simpleWeather) {
        String[] strings = _toSimpleString(simpleWeather);
        AtomicBoolean success = new AtomicBoolean(true);

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + getTable() +
                    " (" +
                    "temperature, " +
                    "rainfall, " +
                    "humidity, " +
                    "wind, " +
                    "clouds, ) " +
                    "VALUES (?,?,?,?,?)");

            IntStream.range(1, strings.length + 1)
                    .forEach(i -> {
                        try {
                            statement.setString(i, strings[i - 1]);
                        } catch (SQLException e) {
                            e.printStackTrace();
                            success.set(false);
                        }
                    });

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            success.set(false);
        }

        return success.get();
    }
}
