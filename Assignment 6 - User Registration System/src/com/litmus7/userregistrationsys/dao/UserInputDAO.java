package com.litmus7.userregistrationsys.dao;

import com.litmus7.userregistrationsys.dto.*;
import com.litmus7.userregistrationsys.jdbcutil.*;
import com.litmus7.userregistrationsys.exception.UserDAOException;
import java.sql.Connection;
import java.sql.*;

public class UserInputDAO {
	public void UserInputDB(User user) throws UserDAOException {

		String checkQuery = "SELECT username FROM users WHERE username = ?";
		String insertQuery = "INSERT INTO users(username, age, email, password) VALUES (?, ?, ?, ?)";

		try (Connection myConn = DBConn.getConnection();
				PreparedStatement checkStmt = myConn.prepareStatement(checkQuery)) {

			checkStmt.setString(1, user.getUsername());
			ResultSet rs = checkStmt.executeQuery();

			if (rs.next()) {
				throw new UserDAOException("User with username '" + user.getUsername() + "' already exists.");
			}
			try (PreparedStatement insStmt = myConn.prepareStatement(insertQuery)) {
				insStmt.setString(1, user.getUsername());
				insStmt.setInt(2, user.getAge());
				insStmt.setString(3, user.getEmail());
				insStmt.setString(4, user.getPassword());

				int rowsOutput = insStmt.executeUpdate();

				if (rowsOutput == 0) {
					throw new UserDAOException("Could Not Update Database.\n");
				}
			} catch (SQLException e) {
				throw new UserDAOException(e.getLocalizedMessage() + "Prepared Query Error.\n");
			}
		} catch (SQLException e) {
			throw new UserDAOException(e.getLocalizedMessage() + "Connection or Prepared Query Error.\n");
		}
	}

	public User returnUserDB(String username) throws UserDAOException {
		String showQuery = "SELECT username, age, email, password FROM users WHERE username = ?";
		
		try (Connection myConn = DBConn.getConnection();
				PreparedStatement showStmt = myConn.prepareStatement(showQuery)) {
			
			showStmt.setString(1, username);
			ResultSet rs = showStmt.executeQuery();
			if (rs.next()) {
				String username1 = rs.getString("username");
				int age= rs.getInt("age");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				User user= new User(username1,age,email,password);
				
				return user;
			} else {
				throw new UserDAOException("User not found.\n");
			}
		} catch (SQLException e) {
			throw new UserDAOException(e.getLocalizedMessage()+"Could not connect to DB or Query error.\n");
		}
	}
}
