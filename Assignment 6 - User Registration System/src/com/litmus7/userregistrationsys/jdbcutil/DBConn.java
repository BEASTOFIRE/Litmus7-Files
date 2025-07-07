package com.litmus7.userregistrationsys.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connection.
 * Provides a method to establish a connection to the MySQL database.
 */
public class DBConn {

    // JDBC URL of the MySQL database
    private static final String url = "jdbc:mysql://localhost:3306/userinfo";

    // MySQL username
    private static final String user = "root";

    // MySQL password
    private static final String password = "issacsql123";

    /**
     * Establishes and returns a connection to the database.
     *
     * @return Connection object to the MySQL database
     * @throws SQLException if the connection attempt fails
     */
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Rethrow with a custom error message
            throw new SQLException("Sql Connection Failed.");
        }
    }
}
