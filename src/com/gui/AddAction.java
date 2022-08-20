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
            Window.getRow();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
