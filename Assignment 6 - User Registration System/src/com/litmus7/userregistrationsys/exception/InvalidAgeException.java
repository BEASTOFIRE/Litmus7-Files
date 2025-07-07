package com.litmus7.userregistrationsys.exception;

public class InvalidAgeException extends Exception{
	/**
     * Constructs a new InvalidAgeException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
    public InvalidAgeException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new InvalidAgeException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public InvalidAgeException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
