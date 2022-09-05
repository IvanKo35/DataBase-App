package com.gui.ButtonAction;

import com.gui.Window;
import com.mysql.request.UpdateRow;
import com.templates.Row;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpdateAction extends AbstractAction {
    private static Row rowFirst;

    public static void setRowFirst(Row row) {
        rowFirst = row;
    }

    public UpdateAction() {
        putValue(Action.SHORT_DESCRIPTION, "Update row");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Window.textFieldName.setText(rowFirst.getNAME());
        Window.textFieldAge.setText(String.valueOf(rowFirst.getAGE()));
        Window.textFieldName.setVisible(true);
        Window.textFieldAge.setVisible(true);
        Window.completeUpdateButton.setVisible(true);
        UpdateRow.setNAMEFirst(rowFirst.getNAME());

    }
}
