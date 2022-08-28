package com.mysql.request;

import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;

import java.sql.*;

public class AddNewRow {

    public AddNewRow(String NAME, int AGE) {
        try {
            PreparedStatement stmt = MysqlServerConnect.connection.prepareStatement("INSERT INTO persons VALUE (?, ?)");
            stmt.setString(1, NAME);
            stmt.setInt(2, AGE);
            int rows = stmt.executeUpdate();


            Window.dBase_name.addElement(NAME);
            Window.dBase_age.addElement(String.valueOf(AGE));
            Window.datalist.setModel(Window.dBase_name);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
