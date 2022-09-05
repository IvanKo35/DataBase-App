package com.gui.ButtonAction;

import com.gui.Window;
import com.templates.Row;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddAction extends AbstractAction {
    private Row row;

    public AddAction() {
        putValue(Action.SHORT_DESCRIPTION, "Add row");
    }

    public Row getRow() {
        return row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.textFieldName.setVisible(true);
        Window.textFieldAge.setVisible(true);
        Window.completeAddButton.setVisible(true);
    }
}
