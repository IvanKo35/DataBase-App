package com.mysql.request;


import com.mysql.connection.MysqlServerConnect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDatabase {

    public static ResultSet getBase() throws SQLException {
        // request to the server
        return MysqlServerConnect.stmt.executeQuery("SELECT * FROM persons");
    }
}
