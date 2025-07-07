package com.litmus7.userregistrationsys.controller;

import com.litmus7.userregistrationsys.dao.*;
import com.litmus7.userregistrationsys.dto.*;
import com.litmus7.userregistrationsys.service.*;

/**
 * Controller class that coordinates between the service and DAO layers
 * for validating user input and retrieving user details.
 */
public class UserController {

    /** Status code indicating a successful operation. */
    public static final int SUCCESS_STATUS_CODE = 200;

    /** Status code indicating an error during processing. */
    public static final int ERROR_STATUS_CODE = 400;

    /** Service class used for input validation and business logic. */
    UserRegistrationService userService = new UserRegistrationService();

    /** DAO class used for interacting with the database. */
    UserInputDAO userDAO = new UserInputDAO();

    /** User object used to hold fetched user details. */
    public User user = new User();

    /**
     * Constructor to initialize UserController with service and DAO dependencies.
     *
     * @param userDAO the DAO implementation to be used
     * @param userService the service layer implementation
     */
    public UserController(UserInputDAO userDAO, UserRegistrationService userService) {
        this.userDAO = userDAO;
        this.userService = userService;
    }

    /**
     * Validates and inserts user data.
     *
     * @param user the user object containing registration details
     * @return a Response object with status and message indicating success or failure
     */
    public Response<String> validateUserInput(User user) {
        try {
            userService.UserRegistrationInput(user);
            return new Response<String>("User Inputted Successfully", SUCCESS_STATUS_CODE, true);
        } catch (Exception e) {
            return new Response<String>(e.getMessage(), ERROR_STATUS_CODE, false);
        }
    }

    /**
     * Retrieves user details from the database by username.
     *
     * @param username the username to be searched
     * @return a Response object containing the User data or an error message
     */
    public Response<User> returnUserDetails(String username) {
        try {
            user = userDAO.returnUserDB(username);
            return new Response<User>("User Returned Successfully", SUCCESS_STATUS_CODE, true, user);
        } catch (Exception e) {
            return new Response<User>(e.getMessage(), ERROR_STATUS_CODE, false);
        }
    }
}
