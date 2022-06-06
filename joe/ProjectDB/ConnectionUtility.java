package dev.joe.ProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    private static ConnectionUtility instance;
    private ConnectionUtility() { super(); }

    public static ConnectionUtility getInstance() {
        if(instance == null) {
            instance = new ConnectionUtility();
        }
        return instance;
    }

    public static Connection getConnection() {

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
