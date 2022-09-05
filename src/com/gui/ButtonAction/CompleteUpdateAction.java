package com.gui.ButtonAction;

import com.gui.Window;
import com.mysql.request.UpdateRow;

import java.awt.event.ActionEvent;

public class CompleteUpdateAction extends CompleteAddAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        Window.name.setText("");
        Window.age.setText("");

        setRow(Window.getRow());
        Window.textFieldName.setVisible(false);
        Window.textFieldAge.setVisible(false);
        Window.completeUpdateButton.setVisible(false);
        UpdateRow.getUpdateRequest(getRow());
        new UpdateRow();
    }
}
