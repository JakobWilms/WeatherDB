package com.github.jakobwilms.weatherdb.db;

import com.github.jakobwilms.weatherdb.Main;
import com.github.jakobwilms.weatherdb.we.SimpleWeather;
import com.github.jakobwilms.weatherdb.we.Weather;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    static Connection connection = null;
    private static String table = "weatherHourly";

    public static Weather @NotNull [] selectAll() {
        return DBSelect.selectAll0();
    }

    public static @Nullable Weather select(int id) {
        return DBSelect.select0(id);
    }

    public static @Nullable SimpleWeather simpleSelect() {
        return DBSelect.simpleSelect0();
    }

    public static boolean deleteAll() {
        return DBDelete.deleteAll0();
    }

    public static boolean delete(int id) {
        return _delete(id, true);
    }

    public static boolean simpleDelete() {
        return DBDelete.simpleDelete0();
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

    public static boolean simpleInsert(@NotNull SimpleWeather simpleWeather) {
        return DBInsert.simpleInsert0(simpleWeather);
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
    static String @NotNull [] _toString(@NotNull Weather weather) {
        return DBConvert._toString0(weather);
    }

    @Contract("_ -> new")
    static @NotNull Weather _toWeather(String @NotNull [] strings) {
        return DBConvert._toWeather0(strings);
    }

    @Contract("_ -> new")
    static String @NotNull [] _toSimpleString(@NotNull SimpleWeather simpleWeather) {
        return DBConvert._toSimpleString0(simpleWeather);
    }

    @Contract("_ -> new")
    static @NotNull SimpleWeather _toSimpleWeather(String @NotNull [] strings) {
        return DBConvert._toSimpleWeather0(strings);
    }

    public static void createTable() {
        DBTable.createTable0();
    }

    public static void createSimpleTable() {
        DBTable.createSimpleTable0();
    }

    public static void createDB(@NotNull Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS " + Main.arguments().getDatabase());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
