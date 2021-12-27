package com.github.jakobwilms.weatherdb.db;

import com.github.jakobwilms.weatherdb.we.Weather;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import static com.github.jakobwilms.weatherdb.db.DBUtils.*;

class DBSelect {

     static Weather @NotNull [] selectAll0() {
         int rows = count();
         Weather[] weathers = new Weather[rows];
         System.out.println(rows);
         IntStream.range(0, rows)
                 .forEach(i -> weathers[i] = select(i));

         return weathers;
    }

    static @Nullable Weather select0(int id) {
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
            return _toWeather(strings);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
