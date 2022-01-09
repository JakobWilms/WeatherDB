package com.github.jakobwilms.weatherdb.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static com.github.jakobwilms.weatherdb.ut.Utils.print;
import static com.github.jakobwilms.weatherdb.db.DBUtils.*;

public class DBDelete {

    static boolean deleteAll0() {
        AtomicBoolean success = new AtomicBoolean(true);
        int rows = count();

        IntStream.range(0, rows)
                .forEach(i -> {
                    if (!_delete(i, false)) success.set(false);
                });

        print("Successfully deleted all elements!");
        return success.get();
    }

    static boolean _delete0(int id, boolean verbose) {
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

    @SuppressWarnings("SqlWithoutWhere")
    static boolean simpleDelete0() {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + getTable());
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
