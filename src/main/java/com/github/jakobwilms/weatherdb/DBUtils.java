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

import static com.github.jakobwilms.weatherdb.Utils.print;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class DBUtils {

    private static Connection connection = null;

    public static int count() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM weather");
            ResultSet set = statement.executeQuery();
            set.next();
            return set.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Weather @NotNull [] selectAll() {
        int rows = count();
        Weather[] weathers = new Weather[rows];
        System.out.println(rows);
        IntStream.range(0, rows)
                .forEach(i -> weathers[i] = select(i));

        return weathers;
    }

    public static @Nullable Weather select(int id) {
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

    public static boolean deleteAll() {
        AtomicBoolean success = new AtomicBoolean(true);
        int rows = count();

        IntStream.range(0, rows)
                .forEach(i -> {
                    if (!_delete(i, false)) success.set(false);
                });

        print("Successfully deleted all elements!");
        return success.get();
    }

    public static boolean delete(int id) {
        return _delete(id, true);
    }

    private static boolean _delete(int id, boolean verbose) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM weather WHERE id = '" + id + "'");
            statement.executeUpdate();

            if (verbose) print("Successfully deleted element " + id + "!");
            return true;
        } catch (SQLException e) {
            print("Couldn't delete element " + id + ":");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insertAll(Weather @NotNull ... weathers) {
        AtomicBoolean b = new AtomicBoolean(true);
        IntStream.range(0, weathers.length)
                .forEach(i -> b.set(_insert(weathers[i], false)));

        print("Successfully inserted all elements!");
        return b.get();
    }

    public static boolean insert(@NotNull Weather weather) {
        return _insert(weather, true);
    }

    private static boolean _insert(@NotNull Weather weather, boolean verbose) {
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

            if (verbose) print("Successfully inserted element " + weather.id() + "!");
        } catch (SQLException e) {
            print("Couldn't insert element " + weather.id() + ":");
            e.printStackTrace();
            success.set(false);
        }

        return success.get();
    }

    public static boolean updateAll(Weather @NotNull ... weathers) {
        AtomicBoolean b = new AtomicBoolean(true);
        IntStream.range(0, weathers.length)
                .forEach(i -> b.set(_update(weathers[i], true)));
        return b.get();
    }

    public static boolean update(@NotNull Weather weather) {
        return _update(weather, false);
    }

    private static boolean _update(@NotNull Weather weather, boolean verbose) {
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

            if (verbose) print("Successfully updated element " + weather.id() + "!");
        } catch (SQLException e) {
            print("Couldn't update element " + weather.id() + ":");
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

    public static Connection connection() {
        return connection;
    }

    public static void setConnection(Connection connection1) {
        if (connection == null) {
            connection = connection1;
        }
    }
}
