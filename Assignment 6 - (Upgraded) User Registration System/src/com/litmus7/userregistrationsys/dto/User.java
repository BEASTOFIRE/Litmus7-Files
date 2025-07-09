package com.litmus7.userregistrationsys.dto;

/**
 * A Data Transfer Object (DTO) representing a User with basic details like
 * username, age, password, and email.
 */
public class User {

	private String username;
	private int age;
	private String password;
	private String email;

	/**
	 * Returns a string representation of the User object.
	 * Useful for logging and displaying user information.
	 *
	 * @return a formatted string containing user fields
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", password=" + password + ", email=" + email + "]";
	}

	/**
	 * Default constructor.
	 * Initializes an empty User object.
	 */
	public User() {
	}

	/**
	 * Parameterized constructor to create a User object with all fields.
	 *
	 * @param username the user's username
	 * @param age      the user's age
	 * @param email    the user's email address
	 * @param password the user's password
	 */
	public User(String username, int age, String email, String password) {
		this.username = username;
		this.age = age;
		this.password = password;
		this.email = email;
	}

	// Getters

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	// Setters

	/**
	 * Sets all user fields at once.
	 *
	 * @param username the username to set
	 * @param age      the age to set
	 * @param password the password to set
	 * @param email    the email to set
	 */
	public void setUser(String username, int age, String password, String email) {
		this.username = username;
		this.age = age;
		this.password = password;
		this.email = email;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
