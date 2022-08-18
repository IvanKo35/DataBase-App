package com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.templates.DatabaseListModel;

public class RefreshAction extends AbstractAction  {

    private DatabaseListModel newdBase_name;
    private DatabaseListModel newdBase_age;

    public RefreshAction() {
        Icon icon = new ImageIcon("icons/icon_refresh.png");
        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, "Refresh list");
    }

    private void getNewModel() throws SQLException {
        com.mysql.connection.MysqlServerConnect.connectToServer();
        ResultSet newResult = com.mysql.connection.request.GetDatabase.getBase();
        newdBase_name = new DatabaseListModel(newResult, 1);
        newdBase_age = new DatabaseListModel(newResult, 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.dBase_name = newdBase_name;
        Window.dBase_age = newdBase_age;
    }
}
