package com.litmus7.userregistrationsys.dao;

import com.litmus7.userregistrationsys.dto.*;
import com.litmus7.userregistrationsys.jdbcutil.*;
import com.litmus7.userregistrationsys.exception.UserDAOException;
import java.sql.Connection;
import java.sql.*;

/**
 * Data Access Object (DAO) class for handling user-related operations with the database.
 */
public class UserInputDAO {

    /**
     * Inserts a new user into the database after checking for username duplication.
     *
     * @param user the User object containing the registration details
     * @throws UserDAOException if the user already exists or if there's a database error
     */
    public void UserInputDB(User user) throws UserDAOException {

        String checkQuery = "SELECT username FROM users WHERE username = ?";
        String insertQuery = "INSERT INTO users(username, age, email, password) VALUES (?, ?, ?, ?)";

        try (
            // Establish database connection
            Connection myConn = DBConn.getConnection();
            // Prepare a statement to check if username already exists
            PreparedStatement checkStmt = myConn.prepareStatement(checkQuery)
        ) {
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();

            // If username already exists, throw custom exception
            if (rs.next()) {
                throw new UserDAOException("User with username '" + user.getUsername() + "' already exists.");
            }

            // Prepare insert statement
            try (PreparedStatement insStmt = myConn.prepareStatement(insertQuery)) {
                insStmt.setString(1, user.getUsername());
                insStmt.setInt(2, user.getAge());
                insStmt.setString(3, user.getEmail());
                insStmt.setString(4, user.getPassword());

                // Execute the insert and check if rows were affected
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

    /**
     * Fetches user details from the database based on the username.
     *
     * @param username the username to search for
     * @return a populated User object if found
     * @throws UserDAOException if the user is not found or if a database error occurs
     */
    public User returnUserDB(String username) throws UserDAOException {
        String showQuery = "SELECT username, age, email, password FROM users WHERE username = ?";

        try (
            // Establish connection and prepare query
            Connection myConn = DBConn.getConnection();
            PreparedStatement showStmt = myConn.prepareStatement(showQuery)
        ) {
            showStmt.setString(1, username);
            ResultSet rs = showStmt.executeQuery();

            // If user is found, extract data into a User object
            if (rs.next()) {
                String username1 = rs.getString("username");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User user = new User(username1, age, email, password);
                return user;
            } else {
                throw new UserDAOException("User not found.\n");
            }
        } catch (SQLException e) {
            throw new UserDAOException(e.getLocalizedMessage() + "Could not connect to DB or Query error.\n");
        }
    }
}
