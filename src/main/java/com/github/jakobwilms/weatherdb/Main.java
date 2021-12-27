package com.github.jakobwilms.weatherdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.github.jakobwilms.weatherdb.DBUtils.*;
import static com.github.jakobwilms.weatherdb.Utils.print;
import static com.github.jakobwilms.weatherdb.WeatherUtils.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/test1", "user", "password")) {
            boolean isValid = connection.isValid(0);
            print("Valid Connection: " + isValid);

            if (!isValid) {
                System.exit(-1);
            }
            setConnection(connection);

            setTable("weatherHourly"); createTable();
            setTable("weatherDaily"); createTable();

            start();
        } catch (SQLException ignored) {
        }
    }
}
