package com.litmus7.userregistrationsys.service;

import com.litmus7.userregistrationsys.dao.UserInputDAO;
import com.litmus7.userregistrationsys.dto.User;
import com.litmus7.userregistrationsys.exception.InvalidAgeException;
import com.litmus7.userregistrationsys.exception.InvalidEmailException;
import com.litmus7.userregistrationsys.exception.UserDAOException;
import com.litmus7.userregistrationsys.exception.WeakPasswordException;
import com.litmus7.userregistrationsys.exception.UserServiceException;

import java.util.regex.Pattern;

public class UserRegistrationService {
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 60;

	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	private int age;
	private String password;
	private String email;

	UserInputDAO userDAO = new UserInputDAO();

	/**
	 * Validates and registers user input.
	 *
	 * @param user The user object to validate and insert into DB.
	 * @throws UserServiceException     If any internal service error occurs.
	 * @throws InvalidAgeException      If age is not between MIN_AGE and MAX_AGE.
	 * @throws InvalidEmailException    If email doesn't match the proper format.
	 * @throws WeakPasswordException    If password is shorter than 6 characters.
	 */
	public void UserRegistrationInput(User user)
			throws UserServiceException, InvalidAgeException, InvalidEmailException, WeakPasswordException {
		try {
			age = user.getAge();
			password = user.getPassword();
			email = user.getEmail();

			if (age < MIN_AGE || age > MAX_AGE) {
				throw new InvalidAgeException("Invalid Age: Age must be between " + MIN_AGE + " & " + MAX_AGE + ".\n");
			}

			if (password.length() < 6) {
				throw new WeakPasswordException("Weak Password: Password must be more than 6 characters.\n");
			}

			if (!Pattern.matches(EMAIL_REGEX, email)) {
				throw new InvalidEmailException("Invalid Email: Email format is incorrect.\n");
			}

			userDAO.UserInputDB(user);
		} catch (UserDAOException e) {
			throw new UserServiceException(e.getMessage());
		}
	}
}
