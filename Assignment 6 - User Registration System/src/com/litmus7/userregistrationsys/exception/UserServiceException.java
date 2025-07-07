package com.litmus7.userregistrationsys.exception;

public class UserServiceException extends Exception{
	/**
     * Constructs a new UserServiceException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
	public UserServiceException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new UserDAOException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public UserServiceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
