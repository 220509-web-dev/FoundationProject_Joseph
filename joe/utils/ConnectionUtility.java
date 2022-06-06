package dev.joe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    public static Connection getConnection(){

        try {
            String dbinfo = "jdbc:postgresql://localhost/postgres?user=postgres&password=password";
            Connection connection = DriverManager.getConnection(dbinfo);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
