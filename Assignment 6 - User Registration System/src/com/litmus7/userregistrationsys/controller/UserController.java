package com.litmus7.userregistrationsys.controller;

import com.litmus7.userregistrationsys.dao.*;
import com.litmus7.userregistrationsys.dto.*;
import com.litmus7.userregistrationsys.service.*;

public class UserController {
	public static final int SUCCESS_STATUS_CODE = 200;
	public static final int ERROR_STATUS_CODE = 400;
	UserRegistrationService userService = new UserRegistrationService();
	UserInputDAO userDAO = new UserInputDAO();
	public User user=new User();

	public UserController(UserInputDAO userDAO, UserRegistrationService userService) {
		this.userDAO = userDAO;
		this.userService = userService;
	}

	public Response<String> validateUserInput(User user) {
		try {
			userService.UserRegistrationInput(user);
			return new Response<String>("User Inputted Successfully", SUCCESS_STATUS_CODE, true);
		} catch (Exception e) {
			return new Response<String>(e.getMessage(), ERROR_STATUS_CODE, false);
		}

	}

	public Response<User> returnUserDetails(String username) {
		try {
			user=userDAO.returnUserDB(username);
			return new Response<User>("User Returned Successfully", SUCCESS_STATUS_CODE, true, user);
		} catch (Exception e) {
			return new Response<User>(e.getMessage(), ERROR_STATUS_CODE, false);
		}
	}
}
