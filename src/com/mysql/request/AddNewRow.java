package com.mysql.request;

import com.mysql.connection.MysqlServerConnect;

import java.sql.*;

public class AddNewRow {

    private static PreparedStatement stmt;

    public AddNewRow(String NAME, int AGE) {
        try {
            stmt = MysqlServerConnect.connection.prepareStatement("INSERT INTO persons VALUE (?, ?)");
            stmt.setString(1, NAME);
            stmt.setInt(2, AGE);
            int rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
