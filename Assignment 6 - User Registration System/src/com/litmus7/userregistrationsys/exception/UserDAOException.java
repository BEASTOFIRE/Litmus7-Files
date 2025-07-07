package com.litmus7.userregistrationsys.exception;

public class UserDAOException extends Exception{
	/**
     * Constructs a new UserDAOException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
	public UserDAOException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new UserDAOException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public UserDAOException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
