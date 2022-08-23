package com.mysql.request;

import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;
import com.templates.DatabaseListModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteRow {
    private static PreparedStatement stmt;
    private static String NAME;
    private static int AGE;

    public DeleteRow() {
        ResultSet newResult;
        try {
            stmt = MysqlServerConnect.connection.prepareStatement("DELETE FROM persons WHERE name = ? AND age = ?");
            stmt.setString(1, NAME);
            stmt.setInt(2, AGE);
            int rows = stmt.executeUpdate();

            newResult = GetDatabase.getBase();
            DatabaseListModel newdBase_name = new DatabaseListModel(newResult, 1);
            DatabaseListModel newdBase_age = new DatabaseListModel(newResult, 2);
            Window.dBase_name = newdBase_name;
            Window.dBase_age = newdBase_age;
            Window.datalist.setModel(Window.dBase_name);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void getRow(String name, int age) {
        NAME = name;
        AGE = age;
    }

}
