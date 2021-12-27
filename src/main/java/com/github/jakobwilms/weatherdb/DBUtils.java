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
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class DBUtils {

    private static Connection connection = null;
    private static String table = "weatherHourly";

    public static int count() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM " + getTable());
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + getTable() + " WHERE id = '" + id + "'");

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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + getTable() + " WHERE id = '" + id + "'");
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
                new MinMaxMedium(parseFloat(strings[5]), parseFloat(strings[6]), parseFloat(strings[7])),
                new MinMaxMedium(parseFloat(strings[8]), parseFloat(strings[9]), parseFloat(strings[10])),
                new MinMaxMedium(parseFloat(strings[11]), parseFloat(strings[12]), parseFloat(strings[13])),
                new MinMaxMedium(parseFloat(strings[14]), parseFloat(strings[15]), parseFloat(strings[16])),
                new MinMaxMedium(parseFloat(strings[17]), parseFloat(strings[18]), parseFloat(strings[19]))
        );
    }

    public static void createTable() {
        try {
            PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " + getTable() + " "
                    + """ 
                    (
                        id                INT UNSIGNED PRIMARY KEY,
                        year              CHAR(4)     NOT NULL,
                        month             CHAR(2)     NOT NULL,
                        day               CHAR(2)     NOT NULL,
                        hour              CHAR(2)     NOT NULL,
                        temperatureMin    VARCHAR(30) NOT NULL,
                        temperatureMax    VARCHAR(30) NOT NULL,
                        temperatureMedium VARCHAR(30) NOT NULL,
                        rainfallMin       VARCHAR(30) NOT NULL,
                        rainfallMax       VARCHAR(30) NOT NULL,
                        rainfallMedium    VARCHAR(30) NOT NULL,
                        humidityMin       VARCHAR(30) NOT NULL,
                        humidityMax       VARCHAR(30) NOT NULL,
                        humidityMedium    VARCHAR(30) NOT NULL,
                        windMin           VARCHAR(30) NOT NULL,
                        windMax           VARCHAR(30) NOT NULL,
                        windMedium        VARCHAR(30) NOT NULL,
                        cloudsMin         VARCHAR(30) NOT NULL,
                        cloudsMax         VARCHAR(30) NOT NULL,
                        cloudsMedium      VARCHAR(30) NOT NULL
                    );""");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection conn() {
        return connection;
    }

    public static void setConnection(Connection connection1) {
        if (connection == null) {
            connection = connection1;
        }
    }

    public static String getTable() {
        return table;
    }

    public static void setTable(String table) {
        DBUtils.table = table;
    }
}
