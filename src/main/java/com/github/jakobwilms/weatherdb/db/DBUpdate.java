package com.github.jakobwilms.weatherdb.db;

import com.github.jakobwilms.weatherdb.we.Weather;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static com.github.jakobwilms.weatherdb.ut.Utils.print;
import static com.github.jakobwilms.weatherdb.db.DBUtils.*;

public class DBUpdate {

    static boolean updateAll0(Weather @NotNull ... weathers) {
        AtomicBoolean b = new AtomicBoolean(true);
        IntStream.range(0, weathers.length)
                .forEach(i -> b.set(_update(weathers[i], true)));
        return b.get();
    }

    static boolean _update0(@NotNull Weather weather, boolean verbose) {
        String[] strings = _toString(weather);
        AtomicBoolean success = new AtomicBoolean(true);

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE " + getTable() + " SET " +
                    "id = ?, year = ?, month = ?, day = ? AND hour = ? " +
                    ",  temperatureMin = ?,  temperatureMax = ?,  temperatureMedium = ? " +
                    ", rainfallMin = ?, rainfallMax = ?,  rainfallMedium = ? " +
                    ", humidityMin = ?, humidityMax = ?, humidityMedium = ? " +
                    ", windMin = ?, windMax = ?, windMedium = ? " +
                    ",  cloudsMin = ?, cloudsMax = ?, cloudsMedium = ? " +
                    "WHERE id = '" + strings[0] + "'");

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

            if (verbose) print("Successfully updated element " + weather.id() + "!");
        } catch (SQLException e) {
            print("Couldn't update element " + weather.id() + ":");
            e.printStackTrace();
            success.set(false);
        }

        return success.get();
    }
}
