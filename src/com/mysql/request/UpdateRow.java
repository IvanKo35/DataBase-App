package com.mysql.request;

import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;
import com.templates.Row;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRow {
    private static String NAMEFirst;
    private static int AGESecond;
    private static String NAMESecond;

    public UpdateRow() {
        try {
            PreparedStatement stmt = MysqlServerConnect.connection
                                        .prepareStatement(
                                                "UPDATE persons.persons SET age = ?, name = ? WHERE name = ?");
            stmt.setInt(1, AGESecond);
            stmt.setString(2, NAMEFirst);
            stmt.setString(3, NAMESecond);

            int rows = stmt.executeUpdate();

            Window.datalist.ensureIndexIsVisible(Window.dBase_name.getSize());
            int idx = Window.dBase_name.indexOf(NAMEFirst);
            String AGEFirst = Window.dBase_age.getElementAt(idx);

            Window.dBase_name.removeElement(NAMEFirst);
            Window.dBase_age.removeElement(AGEFirst);

            Window.dBase_name.InsertElementAt(NAMESecond, idx);
            Window.dBase_age.InsertElementAt(String.valueOf(AGESecond), idx);

            Window.datalist.setModel(Window.dBase_name);

            Window.name.setText("");
            Window.age.setText("");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void getUpdateRequest(Row row) {
        NAMESecond = row.getNAME();
        AGESecond = row.getAGE();
    }

    public static void setNAMEFirst(String NAME) {
        NAMEFirst = NAME;
    }
}
