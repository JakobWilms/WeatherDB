package com.github.jakobwilms.weatherdb;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Utils {

    public static @NotNull Weather[] selectAll(@NotNull Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM weather");
            ResultSet set = statement.executeQuery();
            set.next();
            int rows = set.getInt(1);
            Weather[] weathers = new Weather[rows];
            System.out.println(rows);
            IntStream.range(0, rows)
                    .forEach(i -> weathers[i] = select(connection, i));

            return weathers;
        } catch (SQLException e) {
            e.printStackTrace();
            return new Weather[0];
        }
    }

    public static @Nullable Weather select(@NotNull Connection connection, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM weather WHERE id = '" + id + "'");

            ResultSet set = statement.executeQuery();
            set.next();

            ArrayList<String> list = new ArrayList<>();
            IntStream.range(1, 21).forEach(i -> {
                try {
                    list.add(set.getString(i));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            String[] strings = list.toArray(new String[0]);
            Arrays.stream(strings).forEach(Objects::requireNonNull);
            return toWeather(strings);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteAll(@NotNull Connection connection) {
        AtomicBoolean success = new AtomicBoolean(true);
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM weather");
            ResultSet set = statement.executeQuery();
            set.next();
            int rows = set.getInt(1);

            IntStream.range(0, rows)
                    .forEach(i -> {
                        if (!delete(connection, i)) success.set(false);
                    });
        } catch (SQLException e) {
            e.printStackTrace();
            success.set(false);
        }
        return success.get();
    }

    public static boolean delete(@NotNull Connection connection, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM weather WHERE id = '" + id + "'");
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insert(@NotNull Connection connection, @NotNull Weather weather) {
        String[] strings = toString(weather);
        AtomicBoolean success = new AtomicBoolean(true);

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO weather " +
                    "(id, " +
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
        } catch (SQLException e) {
            e.printStackTrace();
            success.set(false);
            System.out.println("ex");
        }

        return success.get();
    }

    public static boolean update(@NotNull Connection connection, @NotNull Weather weather) {
        String[] strings = toString(weather);
        AtomicBoolean success = new AtomicBoolean(true);

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE weather SET " +
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
        } catch (SQLException e) {
            e.printStackTrace();
            success.set(false);
        }

        return success.get();
    }

    @Contract("_ -> new")
    public static String @NotNull [] toString(@NotNull Weather weather) {
        return new String[]{
                valueOf(weather.id()),
                valueOf(weather.date().year()), valueOf(weather.date().month()), valueOf(weather.date().day()), valueOf(weather.date().hour()),
                valueOf(weather.temperature().min()), valueOf(weather.temperature().max()), valueOf(weather.temperature().medium()),
                valueOf(weather.rainfall().min()), valueOf(weather.rainfall().max()), valueOf(weather.rainfall().medium()),
                valueOf(weather.humidity().min()), valueOf(weather.humidity().max()), valueOf(weather.humidity().medium()),
                valueOf(weather.wind().min()), valueOf(weather.wind().max()), valueOf(weather.wind().medium()),
                valueOf(weather.clouds().min()), valueOf(weather.clouds().max()), valueOf(weather.clouds().medium())
        };
    }

    @Contract("_ -> new")
    public static @NotNull Weather toWeather(String @NotNull [] strings) {
        return new Weather(
                parseInt(strings[0]),
                new Date(parseInt(strings[1]), parseInt(strings[2]), parseInt(strings[3]), parseInt(strings[4])),
                new MinMaxMedium<>(parseInt(strings[5]), parseInt(strings[6]), parseInt(strings[7])),
                new MinMaxMedium<>(parseDouble(strings[8]), parseDouble(strings[9]), parseDouble(strings[10])),
                new MinMaxMedium<>(parseDouble(strings[11]), parseDouble(strings[12]), parseDouble(strings[13])),
                new MinMaxMedium<>(parseInt(strings[14]), parseInt(strings[15]), parseInt(strings[16])),
                new MinMaxMedium<>(parseDouble(strings[17]), parseDouble(strings[18]), parseDouble(strings[19]))
        );
    }
}
