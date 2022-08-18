package com.mysql.connection;

import java.sql.*;

public class MysqlServerConnect {
    private static final String url = "jdbc:mysql://localhost:3306/persons";
    private static final String user = "swingApp";
    private static final String pswd = "password";

    //opening and managing connection
    private static Connection connection;
    public static Statement stmt;

    public static void connectToServer() {
        try {
            //try of connection
            connection = DriverManager.getConnection(url, user, pswd);
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.exit(0);
        }
    }

    public static void disconnectFromServer() throws SQLException {
        //close connection and stmt
        connection.close();
        stmt.close();
    }
}
