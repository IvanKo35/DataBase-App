package com.gui.ButtonAction;

import com.gui.Window;
import com.mysql.request.AddNewRow;
import com.templates.Row;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CompleteAddAction extends AbstractAction {
    private static Row row;

    public CompleteAddAction() {
        putValue(Action.SHORT_DESCRIPTION, "Complete");
    }

    public static Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setRow(Window.getRow());
        Window.textFieldName.setVisible(false);
        Window.textFieldAge.setVisible(false);
        Window.completeAddButton.setVisible(false);
        new AddNewRow(getRow());
    }
}
