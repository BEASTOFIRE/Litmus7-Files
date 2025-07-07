package com.litmus7.userregistrationsys.service;

import com.litmus7.userregistrationsys.dao.UserInputDAO;
import com.litmus7.userregistrationsys.dto.User;
import com.litmus7.userregistrationsys.exception.InvalidAgeException;
import com.litmus7.userregistrationsys.exception.InvalidEmailException;
import com.litmus7.userregistrationsys.exception.WeakPasswordException;
import com.litmus7.userregistrationsys.exception.UserServiceException;

/**
 * Service class for validating and registering users.
 * Handles business logic and validation rules before passing user data to DAO.
 */
public class UserRegistrationService {

	// Temporary storage of user fields
	String username;
	int age;
	String password;
	String email;

	// Data Access Object to interact with the database
	UserInputDAO userDAO = new UserInputDAO();

	/**
	 * Validates user input and forwards valid data to the DAO layer.
	 *
	 * @param user The user object containing registration details
	 * @throws InvalidAgeException      if age is not between 18 and 60
	 * @throws InvalidEmailException    if email does not contain '@' and '.'
	 * @throws WeakPasswordException    if password is shorter than 6 characters
	 * @throws UserServiceException     for any general service-level issues
	 */
	public void UserRegistrationInput(User user)
			throws UserServiceException, InvalidAgeException, InvalidEmailException, WeakPasswordException {
		try {
			username = user.getUsername();

			age = user.getAge();
			if (age < 18 || age > 60) {
				throw new InvalidAgeException("Invalid Age: Age must be between 18 & 60.\n");
			}

			password = user.getPassword();
			if (password.length() < 6) {
				throw new WeakPasswordException("Weak Password: Password must be more than 6 characters.\n");
			}

			email = user.getEmail();
			if (!email.contains("@") || !email.contains(".")) {
				throw new InvalidEmailException("Inavlid Email: Does not contain '@' or '.'\n");
			}

			// Insert the validated user into the database
			userDAO.UserInputDB(user);

		} catch (Exception e) {
			throw new UserServiceException(e.getMessage());
		}
	}
}
