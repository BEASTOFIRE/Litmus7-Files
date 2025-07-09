package com.litmus7.userregistrationsys.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

/**
 * Utility class for handling database connections using JDBC.
 * Loads database credentials from 'db.properties' and provides a reusable connection method.
 */
public class DBUtil {
	
	// JDBC connection properties loaded from db.properties
	private static String url;
	private static String username;
	private static String password;

	// Static block to load the DB configuration only once when the class is loaded
	static {
		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			
			// Load properties from the configuration file
			Properties props = new Properties();
			
			if (input == null) {
				throw new RuntimeException("Unable to find db.properties");
			}

			props.load(input);
			url = props.getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
			
		} catch (Exception e) {
			// Any issue with loading the config will crash the program immediately with a clear message
			throw new RuntimeException("Failed to load DB configuration", e);
		}
	}

	/**
	 * Establishes and returns a new connection to the database using the loaded properties.
	 * 
	 * @return Connection object
	 * @throws SQLException if connection fails
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
