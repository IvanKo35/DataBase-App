package com.mysql.request;

import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;
import com.templates.Row;

import java.sql.*;

public class AddNewRow {

    public AddNewRow(Row row) {
        try {
            PreparedStatement stmt = MysqlServerConnect.connection.prepareStatement("INSERT INTO persons VALUE (?, ?)");
            stmt.setString(1, row.getNAME());
            stmt.setInt(2, row.getAGE());
            int rows = stmt.executeUpdate();


            Window.dBase_name.addElement(row.getNAME());
            Window.dBase_age.addElement(String.valueOf(row.getAGE()));
            Window.datalist.setModel(Window.dBase_name);
            Window.textFieldName.setText("");
            Window.textFieldAge.setText("");


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
