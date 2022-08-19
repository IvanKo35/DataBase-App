package com.mysql.request;

import com.mysql.connection.MysqlServerConnect;
import java.sql.SQLException;

public class AddNewRow {
    public static void addRow(String NAME, int AGE) throws SQLException {
        try {
            int st = MysqlServerConnect.stmt.executeUpdate("INSERT INTO persons.persons VALUES (" + "NAME" +
                                                                ", " + AGE + ")");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
