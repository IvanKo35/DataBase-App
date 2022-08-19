package com.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.mysql.connection.MysqlServerConnect;
import com.mysql.request.GetDatabase;
import com.templates.DatabaseListModel;

public class Window {
    public JFrame jFrame;
    public  static ResultSet dBase;
    public static DatabaseListModel dBase_name;
    public static DatabaseListModel dBase_age;
    public static JList<String> datalist = new JList<>();

    public Window() throws SQLException {
        initialize();
    }

    private void initialize() throws SQLException {
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
        JButton refresh = new JButton(refreshAction);
        String icon_refresh = Objects.requireNonNull(
                this.getClass().getClassLoader().getResource("com/gui/icons/icon_refresh.png")).getFile();
        refresh.setIcon(new ImageIcon(icon_refresh));
        refresh.setContentAreaFilled(false);
        refresh.setBounds(145,60,30,30);
        jFrame.getContentPane().add(refresh);

        var addAction = new AddAction();
        JButton addButton = new JButton(addAction);
        String icon_add = Objects.requireNonNull(
                this.getClass().getClassLoader().getResource("com/gui/icons/icon_add.png")).getFile();
        addButton.setIcon(new ImageIcon(icon_add));
        addButton.setContentAreaFilled(false);
        addButton.setBounds(180,60,30,30);
        jFrame.getContentPane().add(addButton);

        datalist.addListSelectionListener(arg -> {
             String NAME = datalist.getSelectedValue();
             String AGE = dBase_age.getElementAt(dBase_name.indexOf(NAME));
             name.setText(NAME);
             age.setText(AGE);
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
}