package com.gui;
//19.08.22 - not releasing

import com.mysql.connection.MysqlServerConnect;
import com.mysql.request.GetDatabase;
import com.templates.DatabaseListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddAction extends AbstractAction {

    private DatabaseListModel newdBase_name;
    private DatabaseListModel newdBase_age;
    public AddAction() {
        putValue(Action.SHORT_DESCRIPTION, "Add row");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
