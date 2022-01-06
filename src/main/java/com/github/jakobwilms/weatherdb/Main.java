package com.github.jakobwilms.weatherdb;

import com.github.jakobwilms.weatherdb.fx.FXMain;
import com.github.jakobwilms.weatherdb.we.WeatherUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.github.jakobwilms.weatherdb.db.DBUtils.*;
import static com.github.jakobwilms.weatherdb.ut.Utils.print;

public class Main {

    private static Arguments arguments;
    public static final String version;

    static {
        version = "0.0.1";
    }

    public static void main(String[] args) {
        arguments = new Arguments(args);

        try (Connection connection = DriverManager
                .getConnection(String.format("jdbc:mysql://%s/?user=%s&password=%s", arguments().getHost(), arguments().getUsername(), arguments().getPassword()))) {
            print("Creating Test Connection");

            boolean isValid = connection.isValid(0);
            String url = connection.getMetaData().getURL();
            print("URL: " + url.replace(
                    url.substring(url.indexOf(arguments().getPassword()) + 1),
                    url.substring(url.indexOf(arguments().getPassword()) + 1).replace(arguments().getPassword(), "*".repeat(arguments().getPassword().length()))
            ));
            print("User: " + connection.getMetaData().getUserName());
            print("Valid Connection: " + isValid);

            if (!isValid) {
                System.exit(-1);
            }

            createDB(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager
                .getConnection(String.format("jdbc:mysql://%s/%s", arguments().getHost(), arguments.getDatabase()), arguments().getUsername(), arguments.getPassword())) {
            print("Creating Database Connection");

            boolean isValid = connection.isValid(0);
            print("URL: " + connection.getMetaData().getURL());
            print("User: " + connection.getMetaData().getUserName());
            print("Valid Connection: " + isValid);

            if (!isValid) {
                System.exit(-1);
            }
            setConnection(connection);

            setTable("weatherHourly");
            createTable();
            setTable("weatherDaily");
            createTable();

            if (arguments().isGui()) {
                print("Starting GUI");
                FXMain.main(args);
            }

            if (arguments().isMeasure()) {
                print("Starting Measurement");
                WeatherUtils.start();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Arguments arguments() {
        return arguments;
    }
}
