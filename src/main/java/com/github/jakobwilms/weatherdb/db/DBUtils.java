package com.github.jakobwilms.weatherdb.db;

import com.github.jakobwilms.weatherdb.Date;
import com.github.jakobwilms.weatherdb.we.MinMaxMedium;
import com.github.jakobwilms.weatherdb.we.Weather;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class DBUtils {

    static Connection connection = null;
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
        return DBSelect.selectAll0();
    }

    public static @Nullable Weather select(int id) {
        return DBSelect.select0(id);
    }

    public static boolean deleteAll() {
        return DBDelete.deleteAll0();
    }

    public static boolean delete(int id) {
        return _delete(id, true);
    }

    static boolean _delete(int id, boolean verbose) {
        return DBDelete._delete0(id, verbose);
    }

    public static boolean insertAll(Weather @NotNull ... weathers) {
        return DBInsert.insertAll0(weathers);
    }

    public static boolean insert(@NotNull Weather weather) {
        return _insert(weather, true);
    }

    static boolean _insert(@NotNull Weather weather, boolean verbose) {
        return DBInsert._insert0(weather, verbose);
    }

    public static boolean updateAll(Weather @NotNull ... weathers) {
        return DBUpdate.updateAll0(weathers);
    }

    public static boolean update(@NotNull Weather weather) {
        return _update(weather, false);
    }

    static boolean _update(@NotNull Weather weather, boolean verbose) {
        return DBUpdate._update0(weather, verbose);
    }

    @Contract("_ -> new")
    public static String @NotNull [] _toString(@NotNull Weather weather) {
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
    public static @NotNull Weather _toWeather(String @NotNull [] strings) {
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
