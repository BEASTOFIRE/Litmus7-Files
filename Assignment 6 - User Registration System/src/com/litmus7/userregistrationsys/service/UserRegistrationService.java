package com.litmus7.userregistrationsys.service;


import com.litmus7.userregistrationsys.dao.UserInputDAO;
import com.litmus7.userregistrationsys.dto.User;
import com.litmus7.userregistrationsys.exception.InvalidAgeException;
import com.litmus7.userregistrationsys.exception.InvalidEmailException;
import com.litmus7.userregistrationsys.exception.WeakPasswordException;
import com.litmus7.userregistrationsys.exception.UserServiceException;

import java.util.Scanner;
 


public class UserRegistrationService {
	String username;
	int age;
	String password;
	String email;
	UserInputDAO userDAO=new UserInputDAO();
	public void UserRegistrationInput(User user) throws UserServiceException,InvalidAgeException,InvalidEmailException,WeakPasswordException{
		try {
			username = user.getUsername();
			
			age = user.getAge();
			if(age<18||age>60) {
				throw new InvalidAgeException("Invalid Age: Age must be between 18 & 60.\n");
			}
			password = user.getPassword();
			if(password.length()<6) {
				throw new WeakPasswordException("Weak Password: Password must be more than 6 characters.\n");
			}
			email = user.getEmail();
			if(!email.contains("@")||!email.contains(".")) {
				throw new InvalidEmailException("Inavlid Email: Does not contain '@' or '.'\n");
			}
			userDAO.UserInputDB(user);
		}catch (Exception e) {
			throw new UserServiceException(e.getMessage());
			
		} 
	}
}
