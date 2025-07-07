package com.litmus7.userregistrationsys.dto;

public class User {
	private String username;
	private int age;
	private String password;
	private String email;

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", password=" + password + ", email=" + email + "]";
	}
	public User() {
		
	}
	public User(String username, int age, String email, String password) {
		this.username = username;
		this.age = age;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param username the username to set
	 * @param age the age to set
	 * @param password the password to set
	 * @param email the email to set
	 */
	public void setUser(String username, int age, String password, String email) {
		this.username = username;
		this.age = age;
		this.password = password;
		this.email = email;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	

}
