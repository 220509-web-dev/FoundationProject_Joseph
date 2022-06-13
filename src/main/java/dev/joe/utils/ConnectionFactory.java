package dev.joe.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory connectionFactory;

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.err.println("Failed to load Postgresql Driver.");
            throw new RuntimeException(e);
        }
    }

    private Properties props = new Properties();

    private ConnectionFactory() {
        try {
            props.load(new FileReader("C:\\Users\\josep\\Desktop\\Revature\\FoundationProject_Joseph\\src\\main\\resources\\application.properties"));
        } catch (Exception e) {
            System.err.println("Failed to load connection from property files.");
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(props.getProperty("db-url"), props.getProperty("db-username"), props.getProperty("db-password"));

        if (conn == null) {
            throw new RuntimeException("Cannot establish connection to database.");
        }
        return conn;
    }
}
