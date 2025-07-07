package com.litmus7.userregistrationsys.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private static final String url = "jdbc:mysql://localhost:3306/userinfo";
	private static final String user = "root";
	private static final String password = "issacsql123";

	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new SQLException("Sql Connection Failed.");
		}
	}
}
