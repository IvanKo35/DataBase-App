package com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AddAction extends AbstractAction {
    public AddAction() {
        putValue(Action.SHORT_DESCRIPTION, "Add row");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Window.getRow(); //get name and age from text field and add to db
            Window.textFieldName.setText("");
            Window.textFieldAge.setText("");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
