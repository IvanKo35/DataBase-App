package com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.request.GetDatabase;
import com.templates.DatabaseListModel;

public class RefreshAction extends AbstractAction  {

    public RefreshAction() {
        putValue(Action.SHORT_DESCRIPTION, "Refresh list");
    }

    public void refreshTable() {
        ResultSet newResult;
        try {
            newResult = GetDatabase.getBase();
            DatabaseListModel newdBase_name = new DatabaseListModel(newResult, 1);
            DatabaseListModel newdBase_age = new DatabaseListModel(newResult, 2);
            Window.datalist.setModel(newdBase_name);
            Window.dBase_age = newdBase_age;
            Window.dBase_name = newdBase_name;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Window.datalist.clearSelection();
        Window.datalist.clearSelection();
        refreshTable();
    }
}
