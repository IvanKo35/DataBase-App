package com.mysql.request;

import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;
import com.templates.DatabaseListModel;

import java.sql.*;

public class AddNewRow {

    private static PreparedStatement stmt;

    public AddNewRow(String NAME, int AGE) {
        ResultSet newResult;
        try {
            stmt = MysqlServerConnect.connection.prepareStatement("INSERT INTO persons VALUE (?, ?)");
            stmt.setString(1, NAME);
            stmt.setInt(2, AGE);
            int rows = stmt.executeUpdate();

            newResult = GetDatabase.getBase();
            DatabaseListModel newdBase_name = new DatabaseListModel(newResult, 1);
            DatabaseListModel newdBase_age = new DatabaseListModel(newResult, 2);
            Window.datalist.setModel(newdBase_name);
            Window.dBase_age = newdBase_age;


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
