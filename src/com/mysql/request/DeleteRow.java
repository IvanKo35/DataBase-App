package com.mysql.request;

import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteRow {
    private static PreparedStatement stmt;
    private static String NAME;
    private static int AGE;

    public DeleteRow() {
        int confirm = JOptionPane.showOptionDialog(Window.jFrame,
                    "Delete?", "Deleting a row", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                stmt = MysqlServerConnect.connection.prepareStatement("DELETE FROM persons WHERE name = ? AND age = ?");
                stmt.setString(1, NAME);
                stmt.setInt(2, AGE);
                int rows = stmt.executeUpdate();

                int idx = Window.dBase_name.indexOf(NAME);
                Window.dBase_name.remove(idx);
                Window.dBase_age.remove(idx);
                Window.datalist.setModel(Window.dBase_name);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void getRow(String name, int age) {
        NAME = name;
        AGE = age;
    }

}
