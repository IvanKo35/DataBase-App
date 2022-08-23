package com.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.mysql.connection.MysqlServerConnect;
import com.mysql.request.AddNewRow;
import com.mysql.request.DeleteRow;
import com.mysql.request.GetDatabase;
import com.templates.DatabaseListModel;

public class Window {
    public static JFrame jFrame;
    public static ResultSet dBase;
    public static DatabaseListModel dBase_name;
    public static DatabaseListModel dBase_age;
    public static JList<String> datalist = new JList<>();
    public static JTextField textFieldName;
    public static JTextField textFieldAge;

    public Window() throws SQLException {
        jFrame = new JFrame();
        jFrame.setBounds(100,100,450,300);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.getContentPane().setLayout(null);
        jFrame.setLocation(500,300);

        dBase = GetDatabase.getBase();
        DatabaseListModel dBase_name = new DatabaseListModel(dBase, 1);
        DatabaseListModel dBase_age = new DatabaseListModel(dBase, 2);

        datalist.setModel(dBase_name);
        datalist.setBounds(20, 10, 82, 242);
        jFrame.getContentPane().add(datalist);

        JScrollPane scrollPane = new JScrollPane(datalist);
        scrollPane.setBounds(10, 10, 129, 241);
        jFrame.getContentPane().add(scrollPane);

        Label label = new Label("NAME:");
        label.setBounds(145, 10, 33, 22);
        jFrame.getContentPane().add(label);

        final Label name = new Label("");
        name.setBounds(221, 10, 62, 22);
        jFrame.getContentPane().add(name);

        Label label_1 = new Label("AGE:");
        label_1.setBounds(145, 38, 53, 22);
        jFrame.getContentPane().add(label_1);

        Label age = new Label("");
        age.setBounds(231, 38, 37, 22);
        jFrame.getContentPane().add(age);

        var refreshAction = new RefreshAction();
        JButton refreshButton = new JButton(refreshAction);
        String icon_refresh = Objects.requireNonNull(
                this.getClass().getClassLoader().getResource("com/gui/icons/icon_refresh.png")).getFile();
        refreshButton.setIcon(new ImageIcon(icon_refresh));
        refreshButton.setContentAreaFilled(false);
        refreshButton.setBounds(145,60,30,30);
        jFrame.getContentPane().add(refreshButton);

        var addAction = new AddAction();
        JButton addButton = new JButton(addAction);
        String icon_add = Objects.requireNonNull(
                this.getClass().getClassLoader().getResource("com/gui/icons/icon_add.png")).getFile();
        addButton.setIcon(new ImageIcon(icon_add));
        addButton.setContentAreaFilled(false);
        addButton.setBounds(180,60,30,30);
        jFrame.getContentPane().add(addButton);

        var deleteAction = new DeleteAction();
        JButton deleteButton = new JButton(deleteAction);
        String icon_delete = Objects.requireNonNull(
                this.getClass().getClassLoader().getResource("com/gui/icons/icon_minus.png")).getFile();
        deleteButton.setIcon(new ImageIcon(icon_delete));
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBounds(215,60,30,30);
        jFrame.getContentPane().add(deleteButton);

        textFieldName = new JTextField("", 20);
        textFieldAge = new JTextField("", 20);
        textFieldName.setBounds(145,100,140,25);
        textFieldAge.setBounds(145,135,140,25);
        jFrame.getContentPane().add(textFieldName);
        jFrame.getContentPane().add(textFieldAge);

        datalist.addListSelectionListener(arg -> {
             String NAME = datalist.getSelectedValue();
             int idx = datalist.getSelectedIndex();
             String AGE = dBase_age.getElementAt(idx);
             name.setText(NAME);
             age.setText(AGE);
             DeleteRow.getRow(NAME, Integer.parseInt(AGE));
        });

        jFrame.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {}
            public void windowClosing(WindowEvent e) {
                try {
                    MysqlServerConnect.disconnectFromServer();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
            public void windowClosed(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowActivated(WindowEvent e) {}
            public void windowDeactivated(WindowEvent e) {}
        });
    }
    public static void getRow() throws SQLException {
        String textFieldNAME = textFieldName.getText();
        int textFieldAGE = Integer.parseInt(textFieldAge.getText());
        new AddNewRow(textFieldNAME, textFieldAGE);
    }
}