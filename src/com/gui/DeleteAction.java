package com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

import com.mysql.request.DeleteRow;

public class DeleteAction extends AbstractAction {

    public DeleteAction() {
        putValue(Action.SHORT_DESCRIPTION, "Delete row");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new DeleteRow();

    }
}
