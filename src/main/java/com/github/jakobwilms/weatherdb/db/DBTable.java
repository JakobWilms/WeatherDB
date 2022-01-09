package com.github.jakobwilms.weatherdb.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.github.jakobwilms.weatherdb.db.DBUtils.connection;
import static com.github.jakobwilms.weatherdb.db.DBUtils.getTable;

public class DBTable {

    static void createTable0() {
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

    static void createSimpleTable0() {
        try {
            PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " + getTable() + " "
                    + """
                    (
                        temperature VARCHAR(30) NOT NULL,
                        rainfall    VARCHAR(30) NOT NULL,
                        humidity    VARCHAR(30) NOT NULL,
                        wind        VARCHAR(30) NOT NULL,
                        clouds      VARCHAR(30) NOT NULL
                    );""");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
